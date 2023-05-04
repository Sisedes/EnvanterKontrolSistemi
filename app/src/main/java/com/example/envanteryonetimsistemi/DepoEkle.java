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

public class DepoEkle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depo_ekle);

        EditText etdepo_id = findViewById(R.id.et_depo_id);
        EditText etdepo_isim = findViewById(R.id.et_depo_isim);
        EditText etsehirkodu = findViewById(R.id.et_sehirkodu);

        Button btndepokaydet = (Button) findViewById(R.id.btn_depokaydet);

        btndepokaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etdepo_text = etdepo_id.getText().toString();
                String etdepoisim_text = etdepo_isim.getText().toString();
                String etsehirkodu_Text = etsehirkodu.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/depo_ekle.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(DepoEkle.this ,"Basariyla Eklendi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(DepoEkle.this, response,Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("depo_id", etdepo_text);
                        paramV.put("isim", etdepoisim_text);
                        paramV.put("sehir_id", etsehirkodu_Text);
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });
    }
}