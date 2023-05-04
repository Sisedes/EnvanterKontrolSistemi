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

public class TedarikciEkle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tedarikci_ekle);

        EditText et_tedarikciid = findViewById(R.id.et_tedarikciid);
        EditText et_tedarikciad = findViewById(R.id.et_tedarikciad);
        EditText et_tedarikcitel = findViewById(R.id.et_tedarikcitel);
        EditText et_tedarikci_eposta = findViewById(R.id.et_tedarikci_eposta);
        EditText et_tedarikciadres = findViewById(R.id.et_tedarikciadres);
        EditText et_sehirkodu_tedarikci = findViewById(R.id.et_sehirkodu_tedarikci);

        Button btn_tedarikcikaydet = (Button) findViewById(R.id.btn_tedarikcikaydet);

        btn_tedarikcikaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String et_tedarikciid_text = et_tedarikciid.getText().toString();
                String et_tedarikciad_text = et_tedarikciad.getText().toString();
                String et_tedarikcitel_Text = et_tedarikcitel.getText().toString();
                String et_tedarikci_eposta_text = et_tedarikci_eposta.getText().toString();
                String et_tedarikciadres_text = et_tedarikciadres.getText().toString();
                String et_sehirkodu_tedarikci_text = et_sehirkodu_tedarikci.getText().toString();


                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/satici_ekle.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(TedarikciEkle.this ,"Basariyla Eklendi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(TedarikciEkle.this, response,Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("satici_id", et_tedarikciid_text);
                        paramV.put("satici_ad", et_tedarikciad_text);
                        paramV.put("telefon_no", et_tedarikcitel_Text);
                        paramV.put("e_posta", et_tedarikci_eposta_text);
                        paramV.put("adres", et_tedarikciadres_text);
                        paramV.put("sehir_id", et_sehirkodu_tedarikci_text);
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });
    }
}