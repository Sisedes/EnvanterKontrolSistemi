package com.example.envanteryonetimsistemi.DepoBilgi;

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

public class DepoGuncelle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depo_guncelle);

        EditText et_depo_id = findViewById(R.id.et_depo_id);
        EditText et_depo_isim = findViewById(R.id.et_depo_isim);
        EditText et_depo_sehirKod = findViewById(R.id.et_sehirkodu);

        //region lindosh
        Button btndepoguncelle = (Button) findViewById(R.id.btn_depoguncelle); //güncelleme butonu

        btndepoguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = et_depo_id.getText().toString();
                String isim = et_depo_isim.getText().toString();
                String  sehirKod= et_depo_sehirKod.getText().toString();


                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/depo_update.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(DepoGuncelle.this ,"Basariyla Güncellendi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(DepoGuncelle.this, response,Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("depo_id", id);
                        paramV.put("isim", isim);
                        paramV.put("sehir_id", sehirKod);

                        return paramV;
                    }
                };
                queue.add(stringRequest);
                //endregion
            }
        });
    }
}