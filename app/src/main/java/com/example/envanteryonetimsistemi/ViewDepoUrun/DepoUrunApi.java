package com.example.envanteryonetimsistemi.ViewDepoUrun;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DepoUrunApi {

    //buraya php dosyası eklenecek
    @GET("depolarinurunleri.php")
    Call<ArrayList<DepoUrun>> callArraylist();
}
