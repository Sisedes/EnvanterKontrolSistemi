package com.example.envanteryonetimsistemi.AlisBilgi;

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
import com.example.envanteryonetimsistemi.R;

import java.util.HashMap;
import java.util.Map;

public class AlisEkle extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alis_ekle);


        EditText ettedarikci_id = findViewById(R.id.et_tedarikci_id);
        EditText eturun_id = findViewById(R.id.et_urun_id);
        EditText etadet = findViewById(R.id.et_adet);
        

        Button btnaliskaydet = (Button) findViewById(R.id.btn_aliskaydet);

        btnaliskaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ettedarikci_text = ettedarikci_id.getText().toString();
                String eturun_Text = eturun_id.getText().toString();
                String etadet_text = etadet.getText().toString();
                
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/alis_ekle.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(AlisEkle.this ,"Basariyla Eklendi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(AlisEkle.this, response,Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("satici_id", ettedarikci_text);
                        paramV.put("urun_id", eturun_Text);
                        paramV.put("urun_adet", etadet_text);
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });

    }


}