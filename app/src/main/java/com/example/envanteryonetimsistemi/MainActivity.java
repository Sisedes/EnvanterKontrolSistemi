package com.example.envanteryonetimsistemi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.envanteryonetimsistemi.AlisBilgi.Alislar;
import com.example.envanteryonetimsistemi.DepoBilgi.Depolar;
import com.example.envanteryonetimsistemi.MusteriBilgi.Musteriler;
import com.example.envanteryonetimsistemi.SaticiBilgi.Tedarikciler;
import com.example.envanteryonetimsistemi.SatisBilgi.Satislar;
import com.example.envanteryonetimsistemi.UrunBilgi.Urunler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView btnurunler = (TextView) findViewById(R.id.btn_urunler);
        btnurunler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Urunler.class);
                startActivity(intent);
            }
        });

        TextView btnalislar = (TextView) findViewById(R.id.btn_alislar);
        btnalislar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Alislar.class);
                startActivity(intent);
            }
        });
        TextView btndepolar = (TextView) findViewById(R.id.btn_depolar);
        btndepolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Depolar.class);
                startActivity(intent);
            }
        });
        TextView btnsatislar = (TextView) findViewById(R.id.btn_satislar);
        btnsatislar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Satislar.class);
                startActivity(intent);
            }
        });
        TextView btnmusteriler = (TextView) findViewById(R.id.btn_musteriler);
        btnmusteriler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Musteriler.class);
                startActivity(intent);
            }
        });
        TextView btntedarikciler = (TextView) findViewById(R.id.btn_tedarikciler);
        btntedarikciler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Tedarikciler.class);
                startActivity(intent);
            }
        });

    }
}