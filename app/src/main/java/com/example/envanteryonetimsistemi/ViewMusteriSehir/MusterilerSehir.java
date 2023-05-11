package com.example.envanteryonetimsistemi.ViewMusteriSehir;

import static com.example.envanteryonetimsistemi.IPAdresi.ip;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.envanteryonetimsistemi.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MusterilerSehir extends AppCompatActivity {
    //region retrofit ile ekrana yazdırmak için gerekli parametreler
    private MusteriSehirApi musteriSehirApi;
    private ArrayList<MusteriSehir> musteriSehirArrayList;
    private MusteriSehirAdapter musteriSehirAdapter;
    private String BaseUrl="http://"+ip+"/phpKodlari/";
    private RecyclerView rv;
    // endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteriler_sehir);

        //region liste yenile
        ImageButton yenile=findViewById(R.id.btn_yenilemusterisehir);
        yenile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewJsonDataMusteriSehir();
            }
        });
        //endregion

        //region yazdırma
        rv = findViewById(R.id.rv_mutserisehir);
        musteriSehirArrayList = new ArrayList<>();
        viewJsonDataMusteriSehir();

        //endregion
    }
    //region yazdırmak için gerekli metot
    protected void viewJsonDataMusteriSehir() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        musteriSehirApi=retrofit.create((MusteriSehirApi.class));
        Call<ArrayList<MusteriSehir>> msArrayList=musteriSehirApi.callArraylist();
        msArrayList.enqueue(new Callback<ArrayList<MusteriSehir>>() {
            @Override
            public void onResponse(Call<ArrayList<MusteriSehir>> call, retrofit2.Response<ArrayList<MusteriSehir>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    musteriSehirArrayList = response.body();
                    int i = 0;
                    for (i = 0; i < musteriSehirArrayList.size(); i++) {
                        musteriSehirAdapter = new MusteriSehirAdapter(musteriSehirArrayList, MusterilerSehir.this);
                        LinearLayoutManager manager = new LinearLayoutManager(MusterilerSehir.this, RecyclerView.VERTICAL, false);
                        rv.setLayoutManager(manager);
                        rv.setAdapter(musteriSehirAdapter);
                    }
                }else{
                    Toast.makeText(MusterilerSehir.this, "Liste Bos", Toast.LENGTH_SHORT).show();}
            }

            @Override
            public void onFailure(Call<ArrayList<MusteriSehir>> call, Throwable t) {
                Toast.makeText(MusterilerSehir.this, "Veriler getirilemedi.Hata: "  + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //endregion

}