package com.example.envanteryonetimsistemi.AlisBilgi;

import com.google.gson.annotations.SerializedName;

public class Alis {
    @SerializedName("alis_id")
    private int alisid;
    @SerializedName("satici_id")
    private int saticiid;
    @SerializedName("urun_id")
    private int urunid;
    @SerializedName("urun_adet")
    private int urunadet;
    public Alis(int alisid,int saticiid, int urunid, int urunadet)
    {
        this.alisid=alisid;
        this.saticiid=saticiid;
        this.urunid=urunid;
        this.urunadet=urunadet;
    }

    public int getAlisid() {
        return alisid;
    }
    public void setAlisid(int alisid){this.alisid=alisid;}

    public int getSaticiid() {
        return saticiid;
    }
    public void setSaticiid(int saticiid){this.saticiid=saticiid;}
    public int getUrunid() {
        return urunid;
    }
    public void setUrunid(int urunid){this.urunid=urunid;}
    public int getUrunadet() {
        return urunadet;
    }
    public void setUrunadet(int urunadet){this.urunadet=urunadet;}
}