package com.example.envanteryonetimsistemi.MusteriBilgi;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
public interface MusteriApi {
    @GET("musteriler.php")
    Call<ArrayList<Musteri>> callArraylist();
}
