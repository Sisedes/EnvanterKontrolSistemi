package com.example.envanteryonetimsistemi.ViewTedarikciUrun;

import com.google.gson.annotations.SerializedName;

public class TedarikciUrun {

    @SerializedName("satici_as")
    private int saticiad;
    @SerializedName("urun_ismi")
    private int urunismi;
    @SerializedName("fiyat")
    private int fiyat;

    public TedarikciUrun(int saticiad,int urunismi, int fiyat)
    {
        this.saticiad=saticiad;
        this.urunismi=urunismi;
        this.fiyat=fiyat;

    }

    public int getSaticiad() {
        return saticiad;
    }
    public void setSaticiad(int saticiad){this.saticiad=saticiad;}

    public int getUrunismi() {
        return urunismi;
    }
    public void setUrunismi(int urunismi){this.urunismi=urunismi;}
    public int getFiyat() {
        return fiyat;
    }
    public void setFiyat(int fiyat){this.fiyat=fiyat;}

}
