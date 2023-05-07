package com.example.envanteryonetimsistemi.MusteriBilgi;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Musteriler extends AppCompatActivity {
    //region retrofit ile ekrana yazdırmak için gerekli parametreler
    private MusteriApi musteriApi;
    private ArrayList<Musteri> musteriArrayList;
    private MusteriAdapter musteriAdapter;
    private String BaseUrl="http://"+ip+"/phpKodlari/";
    private RecyclerView rv;
    // endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteriler);
        Button btnmusteriekle = (Button) findViewById(R.id.btn_musteriekle);
        btnmusteriekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Musteriler.this, MusteriEkle.class);
                startActivity(intent);
            }
        });

        Button btnmusteriguncelle = (Button) findViewById(R.id.btn_musteriguncelle);
        btnmusteriguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Musteriler.this, MusteriGuncelle.class);
                startActivity(intent);
            }
        });

        Button btnmusterisil= (Button) findViewById(R.id.btn_musterisil);
        EditText et_musteriid=(EditText) findViewById(R.id.et_musteriler_idsil) ;
        //!!id ile silme islemini yapacak buton :
        Button btnmusteriidsil= (Button) findViewById(R.id.btn_musteriid_sil);
        btnmusterisil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_musteriid.setVisibility(View.VISIBLE);
                btnmusteriidsil.setVisibility(View.VISIBLE);
            }
        });

        //region silme işlemi

        btnmusteriidsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=et_musteriid.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/musteri_sil.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(Musteriler.this ,"Basariyla Silindi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(Musteriler.this, response,Toast.LENGTH_SHORT).show();

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
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });
//endregion

        //region yazdırma
        rv=findViewById(R.id.rv_mutseriler);
        musteriArrayList=new ArrayList<>();
        viewJsonData();

        //endregion
    }

    //region yazdırmak için gerekli metot
    private void viewJsonData() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        musteriApi=retrofit.create((MusteriApi.class));
        Call<ArrayList<Musteri>> mlarraylist=musteriApi.callArraylist();
        mlarraylist.enqueue(new Callback<ArrayList<Musteri>>() {
            @Override
            public void onResponse(Call<ArrayList<Musteri>> call, retrofit2.Response<ArrayList<Musteri>> response) {
                if (response.isSuccessful() && response.body() != null){
                    musteriArrayList = response.body();

                int i = 0;
                for (i = 0; i < musteriArrayList.size(); i++) {
                    musteriAdapter = new MusteriAdapter(musteriArrayList, Musteriler.this);
                    LinearLayoutManager manager = new LinearLayoutManager(Musteriler.this, RecyclerView.VERTICAL, false);
                    rv.setLayoutManager(manager);
                    rv.setAdapter(musteriAdapter);
                }
            }else{Toast.makeText(Musteriler.this, "Müşteri Listesi Boş", Toast.LENGTH_SHORT).show();}
        }
            @Override
            public void onFailure(Call<ArrayList<Musteri>> call, Throwable t) {
                Toast.makeText(Musteriler.this, "Veriler getirilemedi.Hata: "  + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //endregion
}