package com.example.envanteryonetimsistemi.ViewTedarikciUrun;

import com.example.envanteryonetimsistemi.ViewDepoUrun.DepoUrun;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TedarikciUrunApi {

    //buraya php dosyası eklenecek
    @GET(".php")
    Call<ArrayList<TedarikciUrun>> callArraylist();
}
