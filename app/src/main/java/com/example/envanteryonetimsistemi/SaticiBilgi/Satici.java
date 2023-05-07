package com.example.envanteryonetimsistemi.SaticiBilgi;

import com.google.gson.annotations.SerializedName;

public class Satici {
    @SerializedName("satici_id")
    private int satici;
    @SerializedName("satici_ad")
    private String saticiad;
    @SerializedName("telefon_no")
    private String telefonno;
    @SerializedName("e_posta")
    private String eposta;
    @SerializedName("adres")
    private String adres;
    @SerializedName("sehir_id")
    private String sehirid;
    public Satici(int satici,String saticiad, String telefonno,String eposta,String adres,String sehirid)
    {
        this.satici=satici;
        this.saticiad=saticiad;
        this.telefonno=telefonno;
        this.eposta=eposta;
        this.adres=adres;
        this.sehirid=sehirid;
    }

    public int getSatici() {
        return satici;
    }
    public void setSatici(int satici){this.satici=satici;}
    public String getSaticiad() {
        return saticiad;
    }
    public void setSaticiad(String saticiad){this.saticiad=saticiad;}
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
