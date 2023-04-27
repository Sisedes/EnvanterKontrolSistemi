package com.example.envanteryonetimsistemi;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Alislar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alislar);

        Connection bag;
        String bagSonucu="";
        TextView alislar=findViewById(R.id.rv_alislar);
        try
        {
            BaglantiYardimcisi yardimci=new BaglantiYardimcisi();
            bag=yardimci.baglanti();
            if(bag!=null)
            {
                String query="SELECT * FROM alis_bilgi";
                Statement durum=bag.createStatement();
                ResultSet sonuc=durum.executeQuery(query);

                while (sonuc.next())
                {
                    alislar.setText(sonuc.getString(1));
                }
            }
            else
            {
                bagSonucu="Baglantinizi Kontrol Edin";
            }
        }
        catch (Exception ex)
        {
            Log.e("Hata",ex.getMessage());
        }
    }
}