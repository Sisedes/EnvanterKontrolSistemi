package com.example.envanteryonetimsistemi.DepoBilgi;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
public interface DepoApi {
    @GET("depolar.php")
    Call<ArrayList<Depo>> callArraylist();
}
