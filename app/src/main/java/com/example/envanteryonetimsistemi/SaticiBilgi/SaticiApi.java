package com.example.envanteryonetimsistemi.SaticiBilgi;

import com.example.envanteryonetimsistemi.SatisBilgi.Satis;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

interface SaticiApi {
    @GET("saticilar.php")
    Call<ArrayList<Satici>> callArraylist();
}
