package com.example.envanteryonetimsistemi.ViewMusteriSehir;

import com.google.gson.annotations.SerializedName;

public class MusteriSehir {

    @SerializedName("sehir_id")
    private int sehirid;
    @SerializedName("musteri_sayisi")
    private int musterisayisi;

    public MusteriSehir(int sehirid,int musterisayisi)
    {
        this.sehirid=sehirid;
        this.musterisayisi=musterisayisi;

    }

    public int getSehiridid() {
        return sehirid;
    }
    public void setSehiridid(int sehirid){this.sehirid=sehirid;}

    public int getMusterisayisi() {
        return musterisayisi;
    }
    public void setMusterisayisi(int musterisayisi){this.musterisayisi=musterisayisi;}

}
