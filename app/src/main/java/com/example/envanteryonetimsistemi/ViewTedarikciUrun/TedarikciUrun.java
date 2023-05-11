package com.example.envanteryonetimsistemi.ViewTedarikciUrun;

import com.google.gson.annotations.SerializedName;

public class TedarikciUrun {

    @SerializedName("satici_ad")
    private String saticiad;
    @SerializedName("urun_ismi")
    private String urunismi;
    @SerializedName("fiyat")
    private int fiyat;

    public TedarikciUrun(String saticiad,String urunismi, int fiyat)
    {
        this.saticiad=saticiad;
        this.urunismi=urunismi;
        this.fiyat=fiyat;

    }

    public String getSaticiad() {
        return saticiad;
    }
    public void setSaticiad(String saticiad){this.saticiad=saticiad;}

    public String getUrunismi() {
        return urunismi;
    }
    public void setUrunismi(String urunismi){this.urunismi=urunismi;}
    public int getFiyat() {
        return fiyat;
    }
    public void setFiyat(int fiyat){this.fiyat=fiyat;}

}
