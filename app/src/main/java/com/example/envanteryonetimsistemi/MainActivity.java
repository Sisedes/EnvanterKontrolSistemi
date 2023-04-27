package com.example.envanteryonetimsistemi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
                Intent intent = new Intent(MainActivity.this, AlisEkle.class);
                startActivity(intent);
            }
        });

    }
}