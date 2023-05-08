package com.example.envanteryonetimsistemi.UrunBilgi;

import static com.example.envanteryonetimsistemi.IPAdresi.ip;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.envanteryonetimsistemi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UrunEkle extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //asagidaki dizi secilebilen depoid icin
    //veritabanina yeni depo eklendiginde asagidaki depolar dizisine yeni deponun id'sinin eklenmesi lazim
    String et_urundepoid;
    ArrayList<String> depolar = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urun_ekle);
        Urunler urunler=new Urunler();
        EditText et_urunisim = findViewById(R.id.et_urunisim);
        EditText et_urunid = findViewById(R.id.et_urunid);
        EditText et_urunfiyat = findViewById(R.id.et_urunfiyat);
        EditText et_urunstok = findViewById(R.id.et_urunstok);

        Button btn_urunkaydet = (Button) findViewById(R.id.btn_urunkaydet);

        Spinner depoSpinner = findViewById(R.id.spinner_depo);


//region urunekle
        btn_urunkaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String et_urunisim_text = et_urunisim.getText().toString();
                String et_urunid_text = et_urunid.getText().toString();
                String et_urunfiyat_Text = et_urunfiyat.getText().toString();
                String et_urunstok_text = et_urunstok.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://"+ip+"/phpKodlari/urun_ekle.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("Basarili"))
                                {
                                    Toast.makeText(UrunEkle.this ,"Basariyla Eklendi",Toast.LENGTH_SHORT).show();
                                }else Toast.makeText(UrunEkle.this, response,Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Hata", error.getLocalizedMessage());
                    }
                }){
                    protected Map<String, String> getParams(){
                        Map<String, String> paramV = new HashMap<>();
                        paramV.put("urun_id", et_urunid_text);
                        paramV.put("isim", et_urunisim_text);
                        paramV.put("fiyat", et_urunfiyat_Text);
                        paramV.put("stok_bilgi", et_urunstok_text);
                        paramV.put("depo_id", et_urundepoid);
                        return paramV;
                    }
                };
                queue.add(stringRequest);
                urunler.viewJsonDataUrunler();
                //onClick içindeki code bloğunun büyük çoğunluğu: https://www.codeseasy.com/google-volley-android/ sitedene alınmıştır(27.04.2023)
            }

        });
//endregion

        //region dropdowna veriçekme
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url ="http://"+ip+"/phpKodlari/dropdown_depo_id.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jarray=new JSONArray(response);
                            for(int i=0; i<jarray.length(); i++)
                            {
                                JSONObject jobject=jarray.getJSONObject(i);
                                String hehe=jobject.getString("depo_id");
                                depolar.add(hehe);
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
        })
        ;
        queue.add(stringRequest);
        //endregion

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, depolar);
        depoSpinner.setAdapter(adapter);
        depoSpinner.setOnItemSelectedListener(this);

        

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String depoid = parent.getItemAtPosition(position).toString();
        TextView tv = findViewById(R.id.tv_selecteddepoid);
        et_urundepoid = parent.getItemAtPosition(position).toString();
        //listeden secilen depo id'yi bu textviewe atadim, bu textviewi görünmez yapar texti veritabanina ekleriz
        tv.setText(et_urundepoid);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
     //bos kalsin
    }


}