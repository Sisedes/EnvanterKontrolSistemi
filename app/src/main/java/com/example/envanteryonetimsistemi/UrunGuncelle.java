package com.example.envanteryonetimsistemi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class UrunGuncelle extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urun_guncelle);
        //buradaki depolar dizisini UrunEkle sinifindan cektim, UrunEkle sinifindaki dizinin guncellenmesi yeterli
        Spinner depoSpinner = findViewById(R.id.spinner_depo);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, UrunEkle.depolar);
        depoSpinner.setAdapter(adapter);
        depoSpinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String depoid = parent.getItemAtPosition(position).toString();
        TextView tv = findViewById(R.id.tv_selecteddepoid);
        tv.setText(depoid);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //bos kalsin
    }
}