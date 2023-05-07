package com.example.envanteryonetimsistemi.AlisBilgi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.envanteryonetimsistemi.R;

import java.util.ArrayList;

public class AlisAdapter extends RecyclerView.Adapter<AlisAdapter.ViewHolderAlis> {
    private ArrayList<Alis> alisArrayList;
    private Context con;

    public AlisAdapter(ArrayList<Alis> alisArrayList,Context con)
    {
        this.alisArrayList=alisArrayList;
        this.con=con;
    }
    @NonNull
    @Override
    public AlisAdapter.ViewHolderAlis onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_alis,parent,false);
        return new ViewHolderAlis(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlisAdapter.ViewHolderAlis holder, int position) {
        Alis alislar=alisArrayList.get(position);
        holder.alici.setText(String.valueOf(alislar.getAlisid()));
        holder.satici.setText(String.valueOf(alislar.getSaticiid()));
        holder.urun.setText(String.valueOf(alislar.getUrunid()));
        holder.urunadet.setText(String.valueOf(alislar.getUrunadet()));
    }

    @Override
    public int getItemCount() {
        return alisArrayList.size();
    }

    public class ViewHolderAlis extends RecyclerView.ViewHolder {
        TextView alici;
        TextView satici;
        TextView urun;
        TextView urunadet;
        public ViewHolderAlis(@NonNull View itemView)
        {
            super(itemView);
            alici=itemView.findViewById(R.id.tv_alisid);
            satici=itemView.findViewById(R.id.tv_tedarikciid);
            urun=itemView.findViewById(R.id.tv_urunid);
            urunadet=itemView.findViewById(R.id.tv_adet);
        }
    }
}
