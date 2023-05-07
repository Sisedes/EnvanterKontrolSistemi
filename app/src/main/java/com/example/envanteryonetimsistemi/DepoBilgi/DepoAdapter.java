package com.example.envanteryonetimsistemi.DepoBilgi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.envanteryonetimsistemi.R;

import java.util.ArrayList;

public class DepoAdapter extends RecyclerView.Adapter<DepoAdapter.ViewHolderDepo>{
    private ArrayList<Depo> depoArrayList;
    private Context con;

    public DepoAdapter(ArrayList<Depo> depoArrayList,Context con)
    {
        this.depoArrayList=depoArrayList;
        this.con=con;
    }
    @NonNull
    @Override
    public DepoAdapter.ViewHolderDepo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_depo,parent,false);
        return new DepoAdapter.ViewHolderDepo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepoAdapter.ViewHolderDepo holder, int position) {
        Depo depolar=depoArrayList.get(position);
        holder.depo.setText(String.valueOf(depolar.getDepoid()));
        holder.isim.setText(depolar.getIsim());
        holder.sehir.setText(String.valueOf(depolar.getSehirid()));
    }

    @Override
    public int getItemCount() {
        return depoArrayList.size();
    }

    public class ViewHolderDepo extends RecyclerView.ViewHolder {
        TextView depo;
        TextView isim;
        TextView sehir;
        public ViewHolderDepo(@NonNull View itemView)
        {
            super(itemView);
            depo=itemView.findViewById(R.id.tv_depoid);
            isim=itemView.findViewById(R.id.tv_depoadi);
            sehir=itemView.findViewById(R.id.tv_deposehirid);
        }
    }
}
