package com.example.envanteryonetimsistemi.UrunBilgi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.envanteryonetimsistemi.R;
import com.example.envanteryonetimsistemi.SatisBilgi.Satis;
import com.example.envanteryonetimsistemi.SatisBilgi.SatisAdapter;

import java.util.ArrayList;

public class UrunAdapter extends RecyclerView.Adapter<UrunAdapter.ViewHolderUrun>{

    private ArrayList<Urun> urunArrayList;
    private Context con;

    public UrunAdapter(ArrayList<Urun> urunArrayList,Context con)
    {
        this.urunArrayList=urunArrayList;
        this.con=con;
    }
    @NonNull
    @Override
    public UrunAdapter.ViewHolderUrun onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_urun,parent,false);
        return new UrunAdapter.ViewHolderUrun(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UrunAdapter.ViewHolderUrun holder, int position) {
        Urun urunler=urunArrayList.get(position);
        holder.urun.setText(String.valueOf(urunler.getUrun()));
        holder.isim.setText(urunler.getIsim());
        holder.fiyat.setText(String.valueOf(urunler.getFiyat()));
        holder.stokbilgi.setText(String.valueOf(urunler.getStokbilgi()));
        holder.depo.setText(urunler.getDepo());
    }

    @Override
    public int getItemCount() {
        return urunArrayList.size();
    }

    public class ViewHolderUrun extends RecyclerView.ViewHolder {
        TextView urun;
        TextView isim;
        TextView fiyat;
        TextView stokbilgi;
        TextView depo;
        public ViewHolderUrun(@NonNull View itemView)
        {
            super(itemView);
            urun=itemView.findViewById(R.id.tv_urunid);
            isim=itemView.findViewById(R.id.tv_urunadi);
            fiyat=itemView.findViewById(R.id.tv_fiyat);
            stokbilgi=itemView.findViewById(R.id.tv_stok);
            depo=itemView.findViewById(R.id.tv_depoid);
        }
    }
}
