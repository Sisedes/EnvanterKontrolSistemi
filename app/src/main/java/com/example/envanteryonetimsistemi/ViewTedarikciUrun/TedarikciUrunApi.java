package com.example.envanteryonetimsistemi.ViewTedarikciUrun;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TedarikciUrunApi {

    //buraya php dosyası eklenecek
    @GET("tedarikcilerin_urunleri.php")
    Call<ArrayList<TedarikciUrun>> callArraylist();
}
