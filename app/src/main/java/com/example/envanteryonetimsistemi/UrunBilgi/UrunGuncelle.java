package com.example.envanteryonetimsistemi.UrunBilgi;

import static com.example.envanteryonetimsistemi.IPAdresi.ip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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

public class UrunGuncelle extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String et_urun_depoid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urun_guncelle);
        //buradaki depolar dizisini UrunEkle sinifindan cektim, UrunEkle sinifindaki dizinin guncellenmesi yeterli
        Spinner depoSpinner = findViewById(R.id.spinner_depo);
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, UrunGuncelle.depolar);
        //depoSpinner.setAdapter(adapter);
        //depoSpinner.setOnItemSelectedListener(this);



        ///update icin
        Urunler urunler=new Urunler();
        EditText et_urun_id = findViewById(R.id.et_urunid);
        EditText et_urun_ad = findViewById(R.id.et_urunisim);
        EditText et_urun_fiyat = findViewById(R.id.et_urunfiyat);
        EditText et_urun_stok = findViewById(R.id.et_urunstok);


        //region lindosh
        Button btn_urun_guncelle = (Button) findViewById(R.id.btn_urunguncelle); //güncelleme butonu

        btn_urun_guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = et_urun_id.getText().toString();
                String ad = et_urun_ad.getText().toString();
                String fiyat= et_urun_fiyat.getText().toString();
                String stok = et_urun_stok.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/urun_update.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(UrunGuncelle.this ,"Basariyla Güncellendi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(UrunGuncelle.this, response,Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("urun_id", id);
                        paramV.put("isim", ad);
                        paramV.put("fiyat", fiyat);
                        paramV.put("stok_bilgi", stok);
                        paramV.put("depo_id", et_urun_depoid);

                        return paramV;
                    }
                };
                queue.add(stringRequest);
                urunler.viewJsonDataUrunler();
                //endregion

            }
        });

        depoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                et_urun_depoid = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String depoid = parent.getItemAtPosition(position).toString();
        TextView tv = findViewById(R.id.tv_selecteddepoid);
        tv.setText(depoid);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //bos kalsin
    }
}