package com.example.envanteryonetimsistemi.AlisBilgi;

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
import com.example.envanteryonetimsistemi.DepoBilgi.Depolar;
import com.example.envanteryonetimsistemi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Alislar extends AppCompatActivity {
//region retrofit ile ekrana yazdırmak için gerekli parametreler
    private AlisApi alisApi;
    private ArrayList<Alis> alisArrayList;
    private AlisAdapter alisAdapter;
    private String BaseUrl="http://"+ip+"/phpKodlari/";
    private RecyclerView rv;
// endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alislar);
        Button btnalisekle = (Button) findViewById(R.id.btn_alisekle);
        btnalisekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alislar.this, AlisEkle.class);
                startActivity(intent);
            }
        });
        Button btnalisguncelle= (Button) findViewById(R.id.btn_alisguncelle);
        btnalisguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alislar.this, AlisGuncelle.class);
                startActivity(intent);
            }
        });

        Button btnalissil= (Button) findViewById(R.id.btn_alissil);
        EditText et_alisid=(EditText) findViewById(R.id.et_alislar_idsil);

        //!!id ile silme islemini yapacak buton :
        Button btnalisidsil= (Button) findViewById(R.id.btn_alisid_sil);



        btnalissil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_alisid.setVisibility(View.VISIBLE);
                btnalisidsil.setVisibility(View.VISIBLE);
            }
        });

//region silme işlemi
        Button alisidsil=findViewById(R.id.btn_alisid_sil);
        EditText et_alislar_idsil = findViewById(R.id.et_alislar_idsil);
        alisidsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=et_alislar_idsil.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/alis_sil.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(Alislar.this ,"Basariyla Silindi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(Alislar.this, response,Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("alis_id", id);
                        return paramV;
                    }
                };
                queue.add(stringRequest);
                viewJsonDataAlislar();
                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });
//endregion

        //region yazdırma
        rv=findViewById(R.id.rv_alislar);
        alisArrayList=new ArrayList<>();
        viewJsonDataAlislar();

        //endregion

    }

    //region yazdırmak için gerekli metot
    protected void viewJsonDataAlislar() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        alisApi=retrofit.create((AlisApi.class));
        Call<ArrayList<Alis>> alarraylist=alisApi.callArraylist();
        alarraylist.enqueue(new Callback<ArrayList<Alis>>() {
            @Override
            public void onResponse(Call<ArrayList<Alis>> call, retrofit2.Response<ArrayList<Alis>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    alisArrayList = response.body();
                    int i = 0;
                    for (i = 0; i < alisArrayList.size(); i++) {
                        alisAdapter = new AlisAdapter(alisArrayList, Alislar.this);
                        LinearLayoutManager manager = new LinearLayoutManager(Alislar.this, RecyclerView.VERTICAL, false);
                        rv.setLayoutManager(manager);
                        rv.setAdapter(alisAdapter);
                    }
                }else{Toast.makeText(Alislar.this, "Alış Listesi Boş", Toast.LENGTH_SHORT).show();}
            }

            @Override
            public void onFailure(Call<ArrayList<Alis>> call, Throwable t) {
                Toast.makeText(Alislar.this, "Veriler getirilemedi.Hata: "  + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //endregion
}