package com.example.envanteryonetimsistemi.SatisBilgi;

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

public class SatisGuncelle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satis_guncelle);
        EditText et_satisid = findViewById(R.id.et_satis_id);
        EditText et_musteriid = findViewById(R.id.et_musteri_id);
        EditText et_urunid = findViewById(R.id.et_urun_id);
        EditText et_adet_ = findViewById(R.id.et_adet);
        EditText et_alissekli_ = findViewById(R.id.et_alissekli);

        //region lindosh
        Button btnsatisguncelle = (Button) findViewById(R.id.btn_satisguncelle); //güncelleme butonu

        btnsatisguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String satisid = et_satisid.getText().toString();
                String musteriid = et_musteriid.getText().toString();
                String urunid= et_urunid.getText().toString();
                String adet = et_adet_.getText().toString();
                String  alissekli= et_alissekli_.getText().toString();


                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/satis_update.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(SatisGuncelle.this ,"Basariyla Güncellendi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(SatisGuncelle.this, response,Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("satis_id", satisid);
                        paramV.put("musteri_id", musteriid);
                        paramV.put("urun_id", urunid);
                        paramV.put("alis_sekli", alissekli);
                        paramV.put("urun_adet", adet);


                        return paramV;
                    }
                };
                queue.add(stringRequest);
                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
                //endregion
            }
        });
    }
}