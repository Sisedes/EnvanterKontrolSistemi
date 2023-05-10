package com.example.envanteryonetimsistemi.ViewTedarikciUrun;

import static com.example.envanteryonetimsistemi.IPAdresi.ip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.envanteryonetimsistemi.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TedarikcilerinUrunleri extends AppCompatActivity {

    //region retrofit ile ekrana yazdırmak için gerekli parametreler
    private TedarikciUrunApi tedarikciUrunApi;
    private ArrayList<TedarikciUrun> tedarikciUrunArrayList;
    private TedarikciUrunAdapter tedarikciUrunAdapter;
    private String BaseUrl="http://"+ip+"/phpKodlari/";
    private RecyclerView rv;
    // endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tedarikcilerin_urunleri);

     //region liste yenile
        ImageButton yenile=findViewById(R.id.btn_yeniletedarikciurun);
        yenile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewJsonDataTedarikciUrun();
            }
        });
        //endregion

        //region yazdırma
        rv = findViewById(R.id.rv_tedarikcilerinurunleri);
        tedarikciUrunArrayList = new ArrayList<>();
        viewJsonDataTedarikciUrun();

        //endregion
    }
    //region yazdırmak için gerekli metot
    protected void viewJsonDataTedarikciUrun() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tedarikciUrunApi=retrofit.create((TedarikciUrunApi.class));
        Call<ArrayList<TedarikciUrun>> tuArrayList=tedarikciUrunApi.callArraylist();
        tuArrayList.enqueue(new Callback<ArrayList<TedarikciUrun>>() {
            @Override
            public void onResponse(Call<ArrayList<TedarikciUrun>> call, retrofit2.Response<ArrayList<TedarikciUrun>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    tedarikciUrunArrayList = response.body();
                    int i = 0;
                    for (i = 0; i < tedarikciUrunArrayList.size(); i++) {
                        tedarikciUrunAdapter = new TedarikciUrunAdapter(tedarikciUrunArrayList, TedarikcilerinUrunleri.this);
                        LinearLayoutManager manager = new LinearLayoutManager(TedarikcilerinUrunleri.this, RecyclerView.VERTICAL, false);
                        rv.setLayoutManager(manager);
                        rv.setAdapter(tedarikciUrunAdapter);
                    }
                }else{
                    Toast.makeText(TedarikcilerinUrunleri.this, "Liste Boş", Toast.LENGTH_SHORT).show();}
            }

            @Override
            public void onFailure(Call<ArrayList<TedarikciUrun>> call, Throwable t) {
                Toast.makeText(TedarikcilerinUrunleri.this, "Veriler getirilemedi.Hata: "  + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //endregion
    }
}