package com.example.envanteryonetimsistemi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Depolar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depolar);
        Button btndepoekle = (Button) findViewById(R.id.btn_depoekle);
        btndepoekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Depolar.this, DepoEkle.class);
                startActivity(intent);
            }
        });

        Button btndepoguncelle= (Button) findViewById(R.id.btn_depoguncelle);
        btndepoguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Depolar.this, DepoGuncelle.class);
                startActivity(intent);
            }
        });
    }
}