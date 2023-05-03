package com.example.envanteryonetimsistemi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Tedarikciler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tedarikciler);

        Button btntedarikciekle = (Button) findViewById(R.id.btn_tedarikciekle);
        btntedarikciekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tedarikciler.this, TedarikciEkle.class);
                startActivity(intent);
            }
        });

        Button btntedarikciguncelle = (Button) findViewById(R.id.btn_tedarikciguncelle);
        btntedarikciguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tedarikciler.this, TedarikciGuncelle.class);
                startActivity(intent);
            }
        });

        Button btntedarikcisil= (Button) findViewById(R.id.btn_tedarikcisil);
        EditText et_tedarikciid=(EditText) findViewById(R.id.et_tedarikciler_idsil);
        //!!id ile silme islemini yapacak buton :
        Button btntedarikciidsil= (Button) findViewById(R.id.btn_tedarikciid_sil);
        btntedarikcisil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_tedarikciid.setVisibility(View.VISIBLE);
                btntedarikciidsil.setVisibility(View.VISIBLE);
            }
        });
    }

}