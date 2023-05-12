package com.example.envanteryonetimsistemi.ViewDepoUrun;

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

public class DepolarinUrunleri extends AppCompatActivity {



    //region retrofit ile ekrana yazdırmak için gerekli parametreler
    private DepoUrunApi depourunApi;
    private ArrayList<DepoUrun> depoUrunArrayList;
    private DepoUrunAdapter depoUrunAdapter;
    private String BaseUrl="http://"+ip+"/phpKodlari/";
    private RecyclerView rv;
    // endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depolarin_urunleri);

        //region liste yenile
        ImageButton yenile=findViewById(R.id.btn_yeniledepourun);
        yenile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewJsonDataDepolarinUrunleri();
            }
        });
        //endregion

        //region yazdırma
        rv = findViewById(R.id.rv_depolarinurunleri);
        depoUrunArrayList = new ArrayList<>();
        viewJsonDataDepolarinUrunleri();

        //endregion
    }
//region yazdırmak için gerekli metot
    //bu regionda bulunan kod yapısı https://www.techypid.com/display-mysql-data-in-android-studio-recyclerview/ sitesinden örnek alınarak yazılmıştır. (12.05.2023)
    protected void viewJsonDataDepolarinUrunleri() {
            Retrofit retrofit=new Retrofit.Builder().baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            depourunApi=retrofit.create((DepoUrunApi.class));
            Call<ArrayList<DepoUrun>> duArrayList=depourunApi.callArraylist();
            duArrayList.enqueue(new Callback<ArrayList<DepoUrun>>() {
                @Override
                public void onResponse(Call<ArrayList<DepoUrun>> call, retrofit2.Response<ArrayList<DepoUrun>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        depoUrunArrayList = response.body();
                        int i = 0;
                        for (i = 0; i < depoUrunArrayList.size(); i++) {
                            depoUrunAdapter = new DepoUrunAdapter(depoUrunArrayList, DepolarinUrunleri.this);
                            LinearLayoutManager manager = new LinearLayoutManager(DepolarinUrunleri.this, RecyclerView.VERTICAL, false);
                            rv.setLayoutManager(manager);
                            rv.setAdapter(depoUrunAdapter);
                        }
                    }else{
                        Toast.makeText(DepolarinUrunleri.this, "Liste Boş", Toast.LENGTH_SHORT).show();}
                }

                @Override
                public void onFailure(Call<ArrayList<DepoUrun>> call, Throwable t) {
                    Toast.makeText(DepolarinUrunleri.this, "Veriler getirilemedi.Hata: "  + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        //endregion


}