package com.example.envanteryonetimsistemi.MusteriBilgi;

import static com.example.envanteryonetimsistemi.IPAdresi.ip;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class MusteriGuncelle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteri_guncelle);

        EditText et_musteri_id = findViewById(R.id.et_musteriid);
        EditText et_musteri_ad = findViewById(R.id.et_musteriad);
        EditText et_musteri_tel = findViewById(R.id.et_musteritel);
        EditText et_musteri_eposta = findViewById(R.id.et_musterieposta);
        EditText et_musteri_adres = findViewById(R.id.et_musteriadres);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText et_musteri_sehir = findViewById(R.id.et_sehirkodu);

        //region lindosh
        Button btnmusteriguncelle = (Button) findViewById(R.id.btn_musteriguncelle); //güncelleme butonu

        btnmusteriguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = et_musteri_id.getText().toString();
                String ad = et_musteri_ad.getText().toString();
                String  tel= et_musteri_tel.getText().toString();
                String eposta = et_musteri_eposta.getText().toString();
                String adres = et_musteri_adres.getText().toString();
                String sehirID = et_musteri_sehir.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/musteri_update.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(MusteriGuncelle.this ,"Basariyla Güncellendi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(MusteriGuncelle.this, response,Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("musteri_id", id);
                        paramV.put("musteri_ad", ad);
                        paramV.put("telefon_no", tel);
                        paramV.put("e_posta", eposta);
                        paramV.put("adres", adres);
                        paramV.put("sehir_id", sehirID);
                        return paramV;
                    }
                };
                queue.add(stringRequest);
                //endregion
            }
        });
    }
}