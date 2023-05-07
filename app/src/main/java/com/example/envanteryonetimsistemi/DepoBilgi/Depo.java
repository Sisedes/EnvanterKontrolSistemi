package com.example.envanteryonetimsistemi.DepoBilgi;

import com.google.gson.annotations.SerializedName;

public class Depo {

    @SerializedName("depo_id")
    private int depoid;
    @SerializedName("isim")
    private String isim;
    @SerializedName("sehir_id")
    private int sehirid;
    public Depo(int depoid,String isim, int sehirid)
    {
        this.depoid=depoid;
        this.isim=isim;
        this.sehirid=sehirid;
    }

    public int getDepoid() {
        return depoid;
    }
    public void setDepoid(int depoid){this.depoid=depoid;}

    public String getIsim() {
        return isim;
    }
    public void setIsim(String isim){this.isim=isim;}
    public int getSehirid() {
        return sehirid;
    }
    public void setSehirid(int sehirid){this.sehirid=sehirid;}
}
