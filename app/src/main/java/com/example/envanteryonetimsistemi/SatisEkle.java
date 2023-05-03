package com.example.envanteryonetimsistemi;

import static com.example.envanteryonetimsistemi.IPAdresi.ip;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SatisEkle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satis_ekle);

        EditText et_satıs_id = findViewById(R.id.et_satıs_id);
        EditText et_musteri_id = findViewById(R.id.et_musteri_id);
        EditText et_urun_id = findViewById(R.id.et_urun_id);
        EditText et_adet = findViewById(R.id.et_adet);
        EditText et_alissekli = findViewById(R.id.et_alissekli);

        Button btn_satiskaydet = (Button) findViewById(R.id.btn_satiskaydet);

        btn_satiskaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String et_satıs_id_text = et_satıs_id.getText().toString();
                String et_musteri_id_text = et_musteri_id.getText().toString();
                String et_urun_id_Text = et_urun_id.getText().toString();
                String et_adet_text = et_adet.getText().toString();
                String et_alissekli_text = et_alissekli.getText().toString();


                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/satis_ekle.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(SatisEkle.this ,"Basariyla Eklendi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(SatisEkle.this, response,Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("satis_id", et_satıs_id_text);
                        paramV.put("musteri_id", et_musteri_id_text);
                        paramV.put("urun_id", et_urun_id_Text);
                        paramV.put("alis_sekli", et_alissekli_text);
                        paramV.put("urun_adet", et_adet_text);
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });
    }
}