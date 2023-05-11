package com.example.envanteryonetimsistemi.ViewMusteriSehir;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MusteriSehirApi {

    //buraya php dosyası eklenecek
    @GET("musteri_sayisi.php")
    Call<ArrayList<MusteriSehir>> callArraylist();
}
