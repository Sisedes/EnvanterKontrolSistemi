package com.example.envanteryonetimsistemi.SatisBilgi;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
public interface SatisApi {
    @GET("satislar.php")
    Call<ArrayList<Satis>> callArraylist();
}
