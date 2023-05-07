package com.example.envanteryonetimsistemi.MusteriBilgi;

import com.google.gson.annotations.SerializedName;

public class Musteri {
    @SerializedName("musteri_id")
    private int musteriid;
    @SerializedName("musteri_ad")
    private String musteriad;
    @SerializedName("telefon_no")
    private String telefonno;
    @SerializedName("e_posta")
    private String eposta;
    @SerializedName("adres")
    private String adres;
    @SerializedName("sehir_id")
    private String sehirid;
    public Musteri(int musteriid,String musteriad, String telefonno,String eposta,String adres,String sehirid)
    {
        this.musteriid=musteriid;
        this.musteriad=musteriad;
        this.telefonno=telefonno;
        this.eposta=eposta;
        this.adres=adres;
        this.sehirid=sehirid;
    }

    public int getMusteriid() {
        return musteriid;
    }
    public void setMusteriid(int musteriid){this.musteriid=musteriid;}
    public String getMusteriad() {
        return musteriad;
    }
    public void setMusteriad(String musteriad){this.musteriad=musteriad;}
    public String getTelefonno() {
        return telefonno;
    }
    public void setTelefonno(String telefonno){this.telefonno=telefonno;}
    public String getEposta() {
        return eposta;
    }
    public void setEposta(String eposta){this.eposta=eposta;}
    public String getAdres() {
        return adres;
    }
    public void setAdres(String adres){this.adres=adres;}
    public String getSehirid() {
        return sehirid;
    }
    public void setSehirid(String sehirid){this.sehirid=sehirid;}
}
