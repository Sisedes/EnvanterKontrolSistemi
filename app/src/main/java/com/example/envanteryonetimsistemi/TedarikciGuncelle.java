package com.example.envanteryonetimsistemi;

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

import java.util.HashMap;
import java.util.Map;

public class TedarikciGuncelle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tedarikci_guncelle);

        EditText et_tedarikci_id = findViewById(R.id.et_tedarikciidE);
        EditText et_tedarikci_ad = findViewById(R.id.et_tedarikciadE);
        EditText et_tedarikci_tel = findViewById(R.id.et_tedarikcitelE);
        EditText et_tedarikci_eposta = findViewById(R.id.et_tedarikci_epostaE);
        EditText et_tedarikci_adres = findViewById(R.id.et_tedarikciadresE);
        EditText et_tedarikci_sehir = findViewById(R.id.et_sehirkodu_tedarikciE);


        //region lindosh
        Button btntedarikguncelle = (Button) findViewById(R.id.btn_tedarikciguncelleE); //güncelleme butonu

        btntedarikguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = et_tedarikci_id.getText().toString();
                String ad = et_tedarikci_ad.getText().toString();
                String  tel= et_tedarikci_tel.getText().toString();
                String eposta = et_tedarikci_eposta.getText().toString();
                String adres = et_tedarikci_adres.getText().toString();
                String sehirID = et_tedarikci_sehir.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/alis_update.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(TedarikciGuncelle.this ,"Basariyla Güncellendi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(TedarikciGuncelle.this, response,Toast.LENGTH_SHORT).show();
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
                        paramV.put("satici_ad", ad);
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