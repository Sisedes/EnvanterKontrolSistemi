package com.example.envanteryonetimsistemi.SaticiBilgi;

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

public class Tedarikciler extends AppCompatActivity {
    //region retrofit ile ekrana yazdırmak için gerekli parametreler
    private SaticiApi saticiApi;
    private ArrayList<Satici> saticiArrayList;
    private SaticiAdapter saticiAdapter;
    private String BaseUrl="http://"+ip+"/phpKodlari/";
    private RecyclerView rv;
    // endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tedarikciler);

        Button btntedarikciekle = (Button) findViewById(R.id.btn_tedarikciekle);
        btntedarikciekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tedarikciler.this, TedarikciEkle.class);
                startActivity(intent);
            }
        });

        Button btntedarikciguncelle = (Button) findViewById(R.id.btn_tedarikciguncelle);
        btntedarikciguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tedarikciler.this, TedarikciGuncelle.class);
                startActivity(intent);
            }
        });

        Button btntedarikcisil= (Button) findViewById(R.id.btn_tedarikcisil);
        EditText et_tedarikciid=(EditText) findViewById(R.id.et_tedarikciler_idsil);
        //!!id ile silme islemini yapacak buton :
        Button btntedarikciidsil= (Button) findViewById(R.id.btn_tedarikciid_sil);
        btntedarikcisil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_tedarikciid.setVisibility(View.VISIBLE);
                btntedarikciidsil.setVisibility(View.VISIBLE);
            }
        });

        //region silme işlemi

        btntedarikciidsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=et_tedarikciid.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/satici_sil.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(Tedarikciler.this ,"Basariyla Silindi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(Tedarikciler.this, response,Toast.LENGTH_SHORT).show();

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
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });
//endregion

        //region yazdırma
        rv=findViewById(R.id.rv_tedarikciler);
        saticiArrayList=new ArrayList<>();
        viewJsonData();

        //endregion
    }

    //region yazdırmak için gerekli metot
    private void viewJsonData() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        saticiApi=retrofit.create((SaticiApi.class));
        Call<ArrayList<Satici>> sslarraylist=saticiApi.callArraylist();
        sslarraylist.enqueue(new Callback<ArrayList<Satici>>() {
            @Override
            public void onResponse(Call<ArrayList<Satici>> call, retrofit2.Response<ArrayList<Satici>> response) {
                if (response.isSuccessful() && response.body() != null){
                    saticiArrayList = response.body();

                    int i = 0;
                    for (i = 0; i < saticiArrayList.size(); i++) {
                        saticiAdapter = new SaticiAdapter(saticiArrayList, Tedarikciler.this);
                        LinearLayoutManager manager = new LinearLayoutManager(Tedarikciler.this, RecyclerView.VERTICAL, false);
                        rv.setLayoutManager(manager);
                        rv.setAdapter(saticiAdapter);
                    }
                }else{Toast.makeText(Tedarikciler.this, "Satış Listesi Boş", Toast.LENGTH_SHORT).show();}
            }
            @Override
            public void onFailure(Call<ArrayList<Satici>> call, Throwable t) {
                Toast.makeText(Tedarikciler.this, "Veriler getirilemedi.Hata: "  + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //endregion
}