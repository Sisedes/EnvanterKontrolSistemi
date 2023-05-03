package com.example.envanteryonetimsistemi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Urunler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urunler);

        Button btnurunekle = (Button) findViewById(R.id.btn_urunekle);
        btnurunekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Urunler.this, UrunEkle.class);
                startActivity(intent);
            }
        });

        Button btnurunguncelle = (Button) findViewById(R.id.btn_urunguncelle);
        btnurunguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Urunler.this, UrunGuncelle.class);
                startActivity(intent);
            }
        });

        Button btnurunsil= (Button) findViewById(R.id.btn_urunsil);
        EditText et_urunid=(EditText) findViewById(R.id.et_urunler_idsil) ;
        //!!id ile silme islemini yapacak buton :
        Button btnurunidsil= (Button) findViewById(R.id.btn_urunid_sil);
        btnurunsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_urunid.setVisibility(View.VISIBLE);
                btnurunidsil.setVisibility(View.VISIBLE);
            }
        });
    }

}