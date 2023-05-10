package com.example.envanteryonetimsistemi.ViewDepoUrun;

import com.google.gson.annotations.SerializedName;

public class DepoUrun {

    @SerializedName("depo_id")
    private int depoid;
    @SerializedName("urun_id")
    private int urunid;
    @SerializedName("urun_isim")
    private int urunisim;

    public DepoUrun(int depoid,int urunid, int urunisim)
    {
        this.depoid=depoid;
        this.urunid=urunid;
        this.urunisim=urunisim;
    }

    public int getDepoid() {
        return depoid;
    }
    public void setDepoid(int depoid){this.depoid=depoid;}

    public int getUrunid() {
        return urunid;
    }
    public void setUrunid(int urunid){this.urunid=urunid;}
    public int getUrunisim() {
        return urunisim;
    }
    public void setUrunisim(int urunisim){this.urunisim=urunisim;}

}
