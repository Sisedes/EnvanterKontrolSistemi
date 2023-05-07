package com.example.envanteryonetimsistemi.SatisBilgi;

import com.google.gson.annotations.SerializedName;

public class Satis {
    @SerializedName("satis_id")
    private int satis;
    @SerializedName("musteri_id")
    private int musteri;
    @SerializedName("urun_id")
    private int urun;
    @SerializedName("alis_sekli")
    private String alissekli;
    @SerializedName("urun_adet")
    private int urunadet;
    public Satis(int satis,int musteri, int urun,String alissekli,int urunadet)
    {
        this.satis=satis;
        this.musteri=musteri;
        this.urun=urun;
        this.alissekli=alissekli;
        this.urunadet=urunadet;
    }

    public int getSatis() {
        return satis;
    }
    public void setSatis(int satis){this.satis=satis;}
    public int getMusteri() {
        return musteri;
    }
    public void setMusteri(int musteri){this.musteri=musteri;}
    public int getUrun() {
        return urun;
    }
    public void setUrun(int urun){this.urun=urun;}
    public String getAlissekli() {
        return alissekli;
    }
    public void setAlissekli(String alissekli){this.alissekli=alissekli;}
    public int getUrunadet() {
        return urunadet;
    }
    public void setUrunadet(int urunadet){this.urunadet=urunadet;}
}
