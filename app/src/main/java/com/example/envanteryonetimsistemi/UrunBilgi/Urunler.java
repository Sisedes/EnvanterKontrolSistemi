package com.example.envanteryonetimsistemi.UrunBilgi;

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
import com.example.envanteryonetimsistemi.R;
import com.example.envanteryonetimsistemi.SatisBilgi.Satis;
import com.example.envanteryonetimsistemi.SatisBilgi.SatisAdapter;
import com.example.envanteryonetimsistemi.SatisBilgi.SatisApi;
import com.example.envanteryonetimsistemi.SatisBilgi.Satislar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Urunler extends AppCompatActivity {
    //region retrofit ile ekrana yazdırmak için gerekli parametreler
    private UrunApi urunApi;
    private ArrayList<Urun> urunArrayList;
    private UrunAdapter urunAdapter;
    private String BaseUrl="http://"+ip+"/phpKodlari/";
    private RecyclerView rv;
    // endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urunler);

        Button btnurunekle = (Button) findViewById(R.id.btn_urunekle);
        btnurunekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Urunler.this, UrunEkle.class);
                startActivity(intent);
            }
        });

        Button btnurunguncelle = (Button) findViewById(R.id.btn_urunguncelle);
        btnurunguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Urunler.this, UrunGuncelle.class);
                startActivity(intent);
            }
        });

        Button btnurunsil= (Button) findViewById(R.id.btn_urunsil);
        EditText et_urunid=(EditText) findViewById(R.id.et_urunler_idsil) ;
        //!!id ile silme islemini yapacak buton :
        Button btnurunidsil= (Button) findViewById(R.id.btn_urunid_sil);
        btnurunsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_urunid.setVisibility(View.VISIBLE);
                btnurunidsil.setVisibility(View.VISIBLE);
            }
        });

        //region silme işlemi
        btnurunidsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=et_urunid.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/urun_sil.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(Urunler.this ,"Basariyla Silindi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(Urunler.this, response,Toast.LENGTH_SHORT).show();

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
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });
//endregion

        //region yazdırma
        rv=findViewById(R.id.rv_urunler);
        urunArrayList=new ArrayList<>();
        viewJsonData();

        //endregion
    }

    //region yazdırmak için gerekli metot
    private void viewJsonData() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        urunApi=retrofit.create((UrunApi.class));
        Call<ArrayList<Urun>> ularraylist=urunApi.callArraylist();
        ularraylist.enqueue(new Callback<ArrayList<Urun>>() {
            @Override
            public void onResponse(Call<ArrayList<Urun>> call, retrofit2.Response<ArrayList<Urun>> response) {
                if (response.isSuccessful() && response.body() != null){
                    urunArrayList = response.body();

                    int i = 0;
                    for (i = 0; i < urunArrayList.size(); i++) {
                        urunAdapter = new UrunAdapter(urunArrayList, Urunler.this);
                        LinearLayoutManager manager = new LinearLayoutManager(Urunler.this, RecyclerView.VERTICAL, false);
                        rv.setLayoutManager(manager);
                        rv.setAdapter(urunAdapter);
                    }
                }else{Toast.makeText(Urunler.this, "Satış Listesi Boş", Toast.LENGTH_SHORT).show();}
            }
            @Override
            public void onFailure(Call<ArrayList<Urun>> call, Throwable t) {
                Toast.makeText(Urunler.this, "Veriler getirilemedi.Hata: "  + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //endregion
}