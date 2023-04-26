package com.example.envanteryonetimsistemi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AlisEkle extends AppCompatActivity {
BaglantiYardimcisi baglantiYardimcisi=new BaglantiYardimcisi();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alis_ekle);


        EditText etalis_id = findViewById(R.id.et_alis_id);
        String etalis_text = etalis_id.getText().toString();

        EditText ettedarikci_id = findViewById(R.id.et_tedarikci_id);
        String ettedarikci_text = ettedarikci_id.getText().toString();

        EditText eturun_id = findViewById(R.id.et_urun_id);
        String eturun_Text = eturun_id.getText().toString();

        EditText etadet = findViewById(R.id.et_adet);
        String etadet_text = etadet.getText().toString();

        Button btnaliskaydet = (Button) findViewById(R.id.btn_aliskaydet);
        btnaliskaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {
                    Connection bag = BaglantiYardimcisi.baglantiSinifi();
                    String islem = "INSERT INTO alis_bilgi (alis_id,satici_id,urun_id,urun_adet) VALUES ("+etalis_text+","+ettedarikci_text+","+eturun_Text+","+etadet_text+")";
                    Statement stmt = bag.createStatement();
                    stmt.executeUpdate(islem);
                }
                catch (SQLException se)
                {
                    Log.e("Baglanti Hatasi", se.getMessage());
                }

            }
        });

    }


}