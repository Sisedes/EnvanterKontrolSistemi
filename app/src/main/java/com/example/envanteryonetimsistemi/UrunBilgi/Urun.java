package com.example.envanteryonetimsistemi.UrunBilgi;
import com.google.gson.annotations.SerializedName;

public class Urun {
    @SerializedName("urun_id")
    private int urun;
    @SerializedName("isim")
    private String isim;
    @SerializedName("fiyat")
    private int fiyat;
    @SerializedName("stok_bilgi")
    private int stokbilgi;
    @SerializedName("depo_id")
    private String depo;
    public Urun(int urun,String isim, int fiyat,int stokbilgi,String depo)
    {
        this.urun=urun;
        this.isim=isim;
        this.fiyat=fiyat;
        this.stokbilgi=stokbilgi;
        this.depo=depo;
    }

    public int getUrun() {
        return urun;
    }
    public void setUrun(int urun){this.urun=urun;}
    public String getIsim() {
        return isim;
    }
    public void setIsim(String isim){this.isim=isim;}
    public int getFiyat() {
        return fiyat;
    }
    public void setFiyat(int fiyat){this.fiyat=fiyat;}
    public int getStokbilgi() {
        return stokbilgi;
    }
    public void setStokbilgi(int stokbilgi){this.stokbilgi=stokbilgi;}
    public String getDepo() {
        return depo;
    }
    public void setDepo(String depo){this.depo=depo;}
}
