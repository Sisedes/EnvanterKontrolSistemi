package com.example.envanteryonetimsistemi;

import static com.example.envanteryonetimsistemi.IPAdresi.ip;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

        Button btnalissil= (Button) findViewById(R.id.btn_alissil);
        EditText et_alisid=(EditText) findViewById(R.id.et_alilsar_idsil);

        //!!id ile silme islemini yapacak buton :
        Button btnalisidsil= (Button) findViewById(R.id.btn_alisid_sil);
        btnalissil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_alisid.setVisibility(View.VISIBLE);
                btnalisidsil.setVisibility(View.VISIBLE);
            }
        });
//region silme işlemi
        Button alisidsil=findViewById(R.id.btn_alisid_sil);
        EditText et_alilsar_idsil = findViewById(R.id.et_alilsar_idsil);
        alisidsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=et_alilsar_idsil.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/alis_sil.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(Alislar.this ,"Basariyla Silindi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(Alislar.this, response,Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("alis_id", id);
                        return paramV;
                    }
                };
                queue.add(stringRequest);

                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }
        });
//endregion

        //region yazdırma
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url ="http://"+ip+"/phpKodlari/alislar.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jarray=new JSONArray(response);
                            for(int i=0; i<jarray.length(); i++)
                            {
                                TableRow row = new TableRow(getApplicationContext());
                                JSONObject jobject=jarray.getJSONObject(i);
                                String alis_id=jobject.getString("alis_id");
                                String satici_id=jobject.getString("satici_id");
                                String urun_id=jobject.getString("urun_id");
                                String urun_adet=jobject.getString("urun_adet");

                                TextView textView1 = new TextView(getApplicationContext());
                                textView1.setText(alis_id);
                                TextView textView2 = new TextView(getApplicationContext());
                                textView2.setText(satici_id);
                                TextView textView3 = new TextView(getApplicationContext());
                                textView3.setText(urun_id);
                                TextView textView4 = new TextView(getApplicationContext());
                                textView4.setText(urun_adet);

                                row.addView(textView1);
                                row.addView(textView2);
                                row.addView(textView3);
                                row.addView(textView4);
                            }
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Hata", error.getLocalizedMessage());
            }
        });
        queue.add(stringRequest);
        //endregion
    }
}