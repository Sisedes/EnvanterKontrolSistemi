package com.example.envanteryonetimsistemi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
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
                Connection bag;
                String bagSonucu="";
                try
                {
                    BaglantiYardimcisi yardimci=new BaglantiYardimcisi();
                    bag=yardimci.baglanti();
                    if(bag!=null)
                    { String values=etalis_text+", "+ettedarikci_text+", "+eturun_Text+", "+0+", "+etadet_text;
                        String query="INSERT INTO alis_bilgi(alis_id,satici_id,urun_id,depo_id,urun_adet) VALUES("+values+")";
                        Statement durum=bag.createStatement();
                        durum.executeUpdate(query);

                    }
                    else
                    {
                        bagSonucu="Baglantinizi Kontrol Edin";
                    }
                }
                catch (Exception ex)
                {

                }

            }
        });

    }


}