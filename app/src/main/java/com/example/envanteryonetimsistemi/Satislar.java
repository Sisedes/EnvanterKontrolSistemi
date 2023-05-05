package com.example.envanteryonetimsistemi;

import static com.example.envanteryonetimsistemi.IPAdresi.ip;

import android.content.Intent;
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

public class Satislar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satislar);
        Button btnsatisekle = (Button) findViewById(R.id.btn_satisekle);
        btnsatisekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Satislar.this, SatisEkle.class);
                startActivity(intent);
            }
        });

        Button btnsatisguncelle = (Button) findViewById(R.id.btn_satisguncelle);
        btnsatisguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Satislar.this, SatisGuncelle.class);
                startActivity(intent);
            }
        });

        Button btnsatissil= (Button) findViewById(R.id.btn_satissil);
        EditText et_satisid=(EditText) findViewById(R.id.et_satislar_idsil);
        //!!id ile silme islemini yapacak buton :
        Button btnsatisidsil= (Button) findViewById(R.id.btn_satisid_sil);
        btnsatissil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_satisid.setVisibility(View.VISIBLE);
                btnsatisidsil.setVisibility(View.VISIBLE);
            }
        });

        //region silme işlemi
        Button satisidsil=findViewById(R.id.btn_satisid_sil);
        EditText et_satislar_idsil = findViewById(R.id.et_satislar_idsil);
        satisidsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=et_satislar_idsil.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/satis_sil.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(Satislar.this ,"Basariyla Silindi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(Satislar.this, response,Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("satis_id", id);
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });
//endregion
    }

}