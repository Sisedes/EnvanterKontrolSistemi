package com.example.envanteryonetimsistemi.MusteriBilgi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.envanteryonetimsistemi.R;

import java.util.ArrayList;

public class MusteriAdapter extends RecyclerView.Adapter<MusteriAdapter.ViewHolderMusteri>{

    private ArrayList<Musteri> musteriArrayList;
    private Context con;

    public MusteriAdapter(ArrayList<Musteri> musteriArrayList,Context con)
    {
        this.musteriArrayList=musteriArrayList;
        this.con=con;
    }
    @NonNull
    @Override
    public MusteriAdapter.ViewHolderMusteri onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_musteri,parent,false);
        return new MusteriAdapter.ViewHolderMusteri(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusteriAdapter.ViewHolderMusteri holder, int position) {
        Musteri musteriler=musteriArrayList.get(position);
        holder.musteriid.setText(String.valueOf(musteriler.getMusteriid()));
        holder.musteriad.setText(musteriler.getMusteriad());
        holder.telefonno.setText(musteriler.getTelefonno());
        holder.eposta.setText(musteriler.getEposta());
        holder.adres.setText(musteriler.getAdres());
        holder.sehirid.setText(musteriler.getSehirid());
    }

    @Override
    public int getItemCount() {
        return musteriArrayList.size();
    }

    public class ViewHolderMusteri extends RecyclerView.ViewHolder {
        TextView musteriid;
        TextView musteriad;
        TextView telefonno;
        TextView eposta;
        TextView adres;
        TextView sehirid;
        public ViewHolderMusteri(@NonNull View itemView)
        {
            super(itemView);
            musteriid=itemView.findViewById(R.id.tv_musteriid);
            musteriad=itemView.findViewById(R.id.tv_musteriadi);
            telefonno=itemView.findViewById(R.id.tv_tel);
            eposta=itemView.findViewById(R.id.tv_mail);
            adres=itemView.findViewById(R.id.tv_adres);
            sehirid=itemView.findViewById(R.id.tv_musterisehirid);
        }
    }
}
