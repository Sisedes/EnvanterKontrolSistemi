package com.example.envanteryonetimsistemi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Alislar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alislar);
        Button btnalisekle = (Button) findViewById(R.id.btn_alisekle);
        btnalisekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alislar.this, AlisEkle.class);
                startActivity(intent);
            }
        });
        Button btnalisguncelle= (Button) findViewById(R.id.btn_alisguncelle);
        btnalisguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alislar.this, AlisGuncelle.class);
                startActivity(intent);
            }
        });

    }
}