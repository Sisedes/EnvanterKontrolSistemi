package com.example.envanteryonetimsistemi;

import static com.example.envanteryonetimsistemi.IPAdresi.ip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.envanteryonetimsistemi.AlisBilgi.Alislar;
import com.example.envanteryonetimsistemi.DepoBilgi.Depo;
import com.example.envanteryonetimsistemi.DepoBilgi.DepoApi;
import com.example.envanteryonetimsistemi.DepoBilgi.Depolar;
import com.example.envanteryonetimsistemi.MusteriBilgi.Musteriler;
import com.example.envanteryonetimsistemi.SaticiBilgi.Tedarikciler;
import com.example.envanteryonetimsistemi.SatisBilgi.Satislar;
import com.example.envanteryonetimsistemi.UrunBilgi.Urun;
import com.example.envanteryonetimsistemi.UrunBilgi.UrunApi;
import com.example.envanteryonetimsistemi.UrunBilgi.Urunler;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView btnurunler = (TextView) findViewById(R.id.btn_urunler);
        TextView totaluruntxt=findViewById(R.id.tv_toplamurun);
        TextView totaldepotxt=findViewById(R.id.tv_toplamkar);
        btnurunler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Urunler.class);
                startActivity(intent);
            }
        });

        TextView btnalislar = (TextView) findViewById(R.id.btn_alislar);
        btnalislar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Alislar.class);
                startActivity(intent);
            }
        });
        TextView btndepolar = (TextView) findViewById(R.id.btn_depolar);
        btndepolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Depolar.class);
                startActivity(intent);
            }
        });
        TextView btnsatislar = (TextView) findViewById(R.id.btn_satislar);
        btnsatislar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Satislar.class);
                startActivity(intent);
            }
        });
        TextView btnmusteriler = (TextView) findViewById(R.id.btn_musteriler);
        btnmusteriler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Musteriler.class);
                startActivity(intent);
            }
        });
        TextView btntedarikciler = (TextView) findViewById(R.id.btn_tedarikciler);
        btntedarikciler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Tedarikciler.class);
                startActivity(intent);
            }
        });

        //region Total ürünleri yazdırma
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+ip+"/phpKodlari/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UrunApi urunAPI = retrofit.create(UrunApi.class);

        Call<ArrayList<Urun>> callurun = urunAPI.callArraylist();

        callurun.enqueue(new Callback<ArrayList<Urun>>() {
            @Override
            public void onResponse(Call<ArrayList<Urun>> call, Response<ArrayList<Urun>> response) {
                if (response.isSuccessful() && response.body() != null){
                    ArrayList<Urun> totalurun = response.body();
                    totaluruntxt.setText(String.valueOf(totalurun.size()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Urun>> call, Throwable t) {
            }
        });

        DepoApi depoAPI = retrofit.create(DepoApi.class);

        Call<ArrayList<Depo>> calldepo = depoAPI.callArraylist();
        calldepo.enqueue(new Callback<ArrayList<Depo>>() {
            @Override
            public void onResponse(Call<ArrayList<Depo>> call, Response<ArrayList<Depo>> response) {
                if (response.isSuccessful() && response.body() != null){
                    ArrayList<Depo> totaldepo = response.body();
                    totaldepotxt.setText(String.valueOf(totaldepo.size()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Depo>> call, Throwable t) {
            }
        });

        //endregion
    }
}