package com.example.envanteryonetimsistemi.AlisBilgi;

import static com.example.envanteryonetimsistemi.IPAdresi.ip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.envanteryonetimsistemi.R;

import java.util.HashMap;
import java.util.Map;

public class AlisGuncelle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_alis_guncelle);
        EditText et_alis_id_u = findViewById(R.id.et_alis_id_u);
        EditText et_tedarikci_id_u = findViewById(R.id.et_tedarikci_id_u);
        EditText et_urun_id_u = findViewById(R.id.et_urun_id_u);
        EditText et_adet_u = findViewById(R.id.et_adet_u);
        Alislar alislar=new Alislar();
        Button btnalisguncelle = (Button) findViewById(R.id.btn_alisguncelle); //güncelleme butonu

        btnalisguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String et_alis_id_u_text = et_alis_id_u.getText().toString();
                String et_tedarikci_id_u_text = et_tedarikci_id_u.getText().toString();
                String et_urun_id_u_Text = et_urun_id_u.getText().toString();
                String et_adet_u_text = et_adet_u.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/alis_update.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(AlisGuncelle.this ,"Basariyla Güncellendi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(AlisGuncelle.this, response,Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("alis_id", et_alis_id_u_text);
                        paramV.put("satici_id", et_tedarikci_id_u_text);
                        paramV.put("urun_id", et_urun_id_u_Text);
                        paramV.put("urun_adet", et_adet_u_text);
                        return paramV;
                    }
                };
                queue.add(stringRequest);
                alislar.viewJsonDataAlislar();
                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });
    }
}