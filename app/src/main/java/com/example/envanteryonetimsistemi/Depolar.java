package com.example.envanteryonetimsistemi;

import static com.example.envanteryonetimsistemi.IPAdresi.ip;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

        Button btndeposil= (Button) findViewById(R.id.btn_deposil);
        EditText et_depoid= (EditText) findViewById(R.id.et_depolar_idsil);
        //!!id ile silme islemini yapacak buton :
        Button btndepoidsil= (Button) findViewById(R.id.btn_depoid_sil);
        btndeposil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_depoid.setVisibility(View.VISIBLE);
                btndepoidsil.setVisibility(View.VISIBLE);
            }
        });

        //region silme işlemi

        btndepoidsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=et_depoid.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/depo_sil.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(Depolar.this ,"Basariyla Silindi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(Depolar.this, response,Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("depo_id", id);
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });
//endregion
    }
}