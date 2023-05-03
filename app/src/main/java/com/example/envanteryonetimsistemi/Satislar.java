package com.example.envanteryonetimsistemi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Satislar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satislar);
        Button btnsatisekle = (Button) findViewById(R.id.btn_satisekle);
        btnsatisekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Satislar.this, SatisEkle.class);
                startActivity(intent);
            }
        });

        Button btnsatisguncelle = (Button) findViewById(R.id.btn_satisguncelle);
        btnsatisguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Satislar.this, SatisGuncelle.class);
                startActivity(intent);
            }
        });

        Button btnsatissil= (Button) findViewById(R.id.btn_satissil);
        EditText et_satisid=(EditText) findViewById(R.id.et_satislar_idsil);
        //!!id ile silme islemini yapacak buton :
        Button btnsatisidsil= (Button) findViewById(R.id.btn_satisid_sil);
        btnsatissil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_satisid.setVisibility(View.VISIBLE);
                btnsatisidsil.setVisibility(View.VISIBLE);
            }
        });
    }

}