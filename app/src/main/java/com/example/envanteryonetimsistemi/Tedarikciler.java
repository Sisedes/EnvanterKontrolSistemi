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

public class Tedarikciler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tedarikciler);

        Button btntedarikciekle = (Button) findViewById(R.id.btn_tedarikciekle);
        btntedarikciekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tedarikciler.this, TedarikciEkle.class);
                startActivity(intent);
            }
        });

        Button btntedarikciguncelle = (Button) findViewById(R.id.btn_tedarikciguncelle);
        btntedarikciguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tedarikciler.this, TedarikciGuncelle.class);
                startActivity(intent);
            }
        });

        Button btntedarikcisil= (Button) findViewById(R.id.btn_tedarikcisil);
        EditText et_tedarikciid=(EditText) findViewById(R.id.et_tedarikciler_idsil);
        //!!id ile silme islemini yapacak buton :
        Button btntedarikciidsil= (Button) findViewById(R.id.btn_tedarikciid_sil);
        btntedarikcisil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_tedarikciid.setVisibility(View.VISIBLE);
                btntedarikciidsil.setVisibility(View.VISIBLE);
            }
        });

        //region silme işlemi

        btntedarikciidsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=et_tedarikciid.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/satici_sil.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(Tedarikciler.this ,"Basariyla Silindi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(Tedarikciler.this, response,Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("satici_id", id);
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