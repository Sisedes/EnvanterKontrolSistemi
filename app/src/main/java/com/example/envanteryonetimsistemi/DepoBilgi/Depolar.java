package com.example.envanteryonetimsistemi.DepoBilgi;

import static com.example.envanteryonetimsistemi.IPAdresi.ip;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
import com.example.envanteryonetimsistemi.ViewDepoUrun.DepolarinUrunleri;
import com.example.envanteryonetimsistemi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Depolar extends AppCompatActivity {
    //region retrofit ile ekrana yazdırmak için gerekli parametreler
    private DepoApi depoApi;
    private ArrayList<Depo> depoArrayList;
    private DepoAdapter depoAdapter;
    private String BaseUrl="http://"+ip+"/phpKodlari/";
    private RecyclerView rv;
    // endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depolar);

        ImageButton depolarurun= (ImageButton) findViewById(R.id.btn_depourunleri);

        depolarurun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Depolar.this, DepolarinUrunleri.class);
                startActivity(intent);
            }
        });

        //region liste yenileme
        ImageButton yenile=findViewById(R.id.btn_depolar_listeguncelle);
        yenile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewJsonDataDepolar();
            }
        });
        //endregion
        Button btndepoekle = (Button) findViewById(R.id.btn_depoekle);
        btndepoekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Depolar.this, DepoEkle.class);
                startActivity(intent);
            }
        });

        Button btndepoguncelle= (Button) findViewById(R.id.btn_depoguncelle);
        btndepoguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Depolar.this, DepoGuncelle.class);
                startActivity(intent);
            }
        });

        Button btndeposil= (Button) findViewById(R.id.btn_deposil);
        EditText et_depoid= (EditText) findViewById(R.id.et_depolar_idsil);
        //!!id ile silme islemini yapacak buton :
        Button btndepoidsil= (Button) findViewById(R.id.btn_depoid_sil);
        btndeposil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_depoid.setVisibility(View.VISIBLE);
                btndepoidsil.setVisibility(View.VISIBLE);
            }
        });

        //region silme işlemi

        btndepoidsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=et_depoid.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/depo_sil.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(Depolar.this ,"Basariyla Silindi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(Depolar.this, response,Toast.LENGTH_SHORT).show();

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
                        return paramV;
                    }
                };
                queue.add(stringRequest);
                viewJsonDataDepolar();
                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });
//endregion

        //region yazdırma
        rv=findViewById(R.id.rv_depolar);
        depoArrayList=new ArrayList<>();
        viewJsonDataDepolar();

        //endregion

    }

    //region yazdırmak için gerekli metot
    //bu regionda bulunan kod yapısı https://www.techypid.com/display-mysql-data-in-android-studio-recyclerview/ sitesinden örnek alınarak yazılmıştır.(12.05.2023)
    protected void viewJsonDataDepolar() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        depoApi=retrofit.create((DepoApi.class));
        Call<ArrayList<Depo>> dlarraylist=depoApi.callArraylist();
        dlarraylist.enqueue(new Callback<ArrayList<Depo>>() {
            @Override
            public void onResponse(Call<ArrayList<Depo>> call, retrofit2.Response<ArrayList<Depo>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    depoArrayList = response.body();
                    int i = 0;
                    for (i = 0; i < depoArrayList.size(); i++) {
                        depoAdapter = new DepoAdapter(depoArrayList, Depolar.this);
                        LinearLayoutManager manager = new LinearLayoutManager(Depolar.this, RecyclerView.VERTICAL, false);
                        rv.setLayoutManager(manager);
                        rv.setAdapter(depoAdapter);
                    }
                }else{Toast.makeText(Depolar.this, "Depo Listesi Boş", Toast.LENGTH_SHORT).show();}
            }

            @Override
            public void onFailure(Call<ArrayList<Depo>> call, Throwable t) {
                Toast.makeText(Depolar.this, "Veriler getirilemedi.Hata: "  + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //endregion
}