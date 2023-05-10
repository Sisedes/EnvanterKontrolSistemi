package com.example.envanteryonetimsistemi.ViewMusteriSehir;

import com.example.envanteryonetimsistemi.ViewDepoUrun.DepoUrun;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MusteriSehirApi {

    //buraya php dosyası eklenecek
    @GET(".php")
    Call<ArrayList<MusteriSehir>> callArraylist();
}
