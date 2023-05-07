package com.example.envanteryonetimsistemi.AlisBilgi;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
interface AlisApi {
    @GET("alislar.php")
    Call<ArrayList<Alis>> callArraylist();
}
