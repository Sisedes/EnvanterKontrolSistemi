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

public class MusteriEkle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteri_ekle);

        EditText etmusteri_id = findViewById(R.id.et_musteriid);
        EditText etmusteriad = findViewById(R.id.et_musteriad);
        EditText etmusteritel = findViewById(R.id.et_musteritel);
        EditText etmusterieposta = findViewById(R.id.et_musterieposta);
        EditText etmusteriadres = findViewById(R.id.et_musteriadres);
        EditText etsehir_kodu = findViewById(R.id.et_sehir_kodu);

        Button btnmusterikaydet = (Button) findViewById(R.id.btn_musterikaydet);

        btnmusterikaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etmusteri_id_text = etmusteri_id.getText().toString();
                String etmusteriad_text = etmusteriad.getText().toString();
                String etmusteritel_Text = etmusteritel.getText().toString();
                String etmusterieposta_text = etmusterieposta.getText().toString();
                String etmusteriadres_text = etmusteriadres.getText().toString();
                String etsehir_kodu_Text = etsehir_kodu.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/musteri_ekle.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(MusteriEkle.this ,"Basariyla Eklendi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(MusteriEkle.this, response,Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("musteri_id", etmusteri_id_text);
                        paramV.put("musteri_ad", etmusteriad_text);
                        paramV.put("telefon_no", etmusteritel_Text);
                        paramV.put("e_posta", etmusterieposta_text);
                        paramV.put("adres", etmusteriadres_text);
                        paramV.put("sehir_id", etsehir_kodu_Text);
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });
    }
}