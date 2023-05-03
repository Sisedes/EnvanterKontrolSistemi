package com.example.envanteryonetimsistemi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Musteriler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteriler);
        Button btnmusteriekle = (Button) findViewById(R.id.btn_musteriekle);
        btnmusteriekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Musteriler.this, MusteriEkle.class);
                startActivity(intent);
            }
        });

        Button btnmusteriguncelle = (Button) findViewById(R.id.btn_musteriguncelle);
        btnmusteriguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Musteriler.this, MusteriGuncelle.class);
                startActivity(intent);
            }
        });

        Button btnmusterisil= (Button) findViewById(R.id.btn_musterisil);
        EditText et_musteriid=(EditText) findViewById(R.id.et_musteriler_idsil) ;
        //!!id ile silme islemini yapacak buton :
        Button btnmusteriidsil= (Button) findViewById(R.id.btn_musteriid_sil);
        btnmusterisil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_musteriid.setVisibility(View.VISIBLE);
                btnmusteriidsil.setVisibility(View.VISIBLE);
            }
        });
    }
}