package com.example.envanteryonetimsistemi.UrunBilgi;

import com.example.envanteryonetimsistemi.SatisBilgi.Satis;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UrunApi {
    @GET("urunler.php")
    Call<ArrayList<Urun>> callArraylist();
}
