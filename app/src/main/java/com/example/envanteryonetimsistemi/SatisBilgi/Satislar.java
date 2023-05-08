package com.example.envanteryonetimsistemi.SatisBilgi;

import static com.example.envanteryonetimsistemi.IPAdresi.ip;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.envanteryonetimsistemi.MusteriBilgi.Musteri;
import com.example.envanteryonetimsistemi.MusteriBilgi.MusteriAdapter;
import com.example.envanteryonetimsistemi.MusteriBilgi.MusteriApi;
import com.example.envanteryonetimsistemi.MusteriBilgi.Musteriler;
import com.example.envanteryonetimsistemi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Satislar extends AppCompatActivity {
    //region retrofit ile ekrana yazdırmak için gerekli parametreler
    private SatisApi satisApi;
    private ArrayList<Satis> satisArrayList;
    private SatisAdapter satisAdapter;
    private String BaseUrl="http://"+ip+"/phpKodlari/";
    private RecyclerView rv;
    // endregion
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
                viewJsonDataSatislar();
                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });
//endregion

        //region yazdırma
        rv=findViewById(R.id.rv_satislar);
        satisArrayList=new ArrayList<>();
        viewJsonDataSatislar();

        //endregion
    }

    //region yazdırmak için gerekli metot
    protected void viewJsonDataSatislar() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        satisApi=retrofit.create((SatisApi.class));
        Call<ArrayList<Satis>> slarraylist=satisApi.callArraylist();
        slarraylist.enqueue(new Callback<ArrayList<Satis>>() {
            @Override
            public void onResponse(Call<ArrayList<Satis>> call, retrofit2.Response<ArrayList<Satis>> response) {
                if (response.isSuccessful() && response.body() != null){
                    satisArrayList = response.body();

                    int i = 0;
                    for (i = 0; i < satisArrayList.size(); i++) {
                        satisAdapter = new SatisAdapter(satisArrayList, Satislar.this);
                        LinearLayoutManager manager = new LinearLayoutManager(Satislar.this, RecyclerView.VERTICAL, false);
                        rv.setLayoutManager(manager);
                        rv.setAdapter(satisAdapter);
                    }
                }else{Toast.makeText(Satislar.this, "Satış Listesi Boş", Toast.LENGTH_SHORT).show();}
            }
            @Override
            public void onFailure(Call<ArrayList<Satis>> call, Throwable t) {
                Toast.makeText(Satislar.this, "Veriler getirilemedi.Hata: "  + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //endregion
}