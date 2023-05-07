package com.example.envanteryonetimsistemi.SatisBilgi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.envanteryonetimsistemi.R;

import java.util.ArrayList;


public class SatisAdapter extends RecyclerView.Adapter<SatisAdapter.ViewHolderSatis>{
    private ArrayList<Satis> satisArrayList;
    private Context con;

    public SatisAdapter(ArrayList<Satis> satisArrayList,Context con)
    {
        this.satisArrayList=satisArrayList;
        this.con=con;
    }
    @NonNull
    @Override
    public SatisAdapter.ViewHolderSatis onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_satis,parent,false);
        return new SatisAdapter.ViewHolderSatis(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SatisAdapter.ViewHolderSatis holder, int position) {
        Satis satislar=satisArrayList.get(position);
        holder.satis.setText(String.valueOf(satislar.getSatis()));
        holder.musteri.setText(String.valueOf(satislar.getMusteri()));
        holder.urun.setText(String.valueOf(satislar.getUrun()));
        //holder.alissekli.setText(satislar.getAlissekli());
        holder.urunadet.setText(String.valueOf(satislar.getUrunadet()));
    }

    @Override
    public int getItemCount() {
        return satisArrayList.size();
    }

    public class ViewHolderSatis extends RecyclerView.ViewHolder {
        TextView satis;
        TextView musteri;
        TextView urun;
        //TextView alissekli;
        TextView urunadet;
        public ViewHolderSatis(@NonNull View itemView)
        {
            super(itemView);
            satis=itemView.findViewById(R.id.tv_satisid);
            musteri=itemView.findViewById(R.id.tv_musteriid);
            urun=itemView.findViewById(R.id.tv_urunid);
            //alissekli=itemView.findViewById(R.id.tv_adet);
            urunadet=itemView.findViewById(R.id.tv_adet);
        }
    }
}
