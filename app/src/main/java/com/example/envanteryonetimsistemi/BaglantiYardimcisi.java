package com.example.envanteryonetimsistemi;

import android.os.StrictMode;
import android.util.Log;

import java.sql.*;

public class BaglantiYardimcisi {


    public static Connection baglantiSinifi(){

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection baglanti=null;

        try
        {
        baglanti=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/envanter","root","kaan1234");
        }
        catch (Exception ex)
        {
            Log.e("Baglanti Hatası", ex.getMessage());
        }

        return baglanti;
    }
}
