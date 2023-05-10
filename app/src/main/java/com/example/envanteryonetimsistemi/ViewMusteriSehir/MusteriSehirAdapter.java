package com.example.envanteryonetimsistemi.ViewMusteriSehir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.envanteryonetimsistemi.R;


import java.util.ArrayList;

public class MusteriSehirAdapter extends RecyclerView.Adapter<MusteriSehirAdapter.ViewHolderMusteriSehir>{

    private ArrayList<MusteriSehir> musteriSehirArrayList;
    private Context con;

    public MusteriSehirAdapter(ArrayList<MusteriSehir> musteriSehirArrayList, Context con)
    {
        this.musteriSehirArrayList=musteriSehirArrayList;
        this.con=con;
    }
    @NonNull

    @Override
    public MusteriSehirAdapter.ViewHolderMusteriSehir onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_musterisehir,parent,false);
        return new MusteriSehirAdapter.ViewHolderMusteriSehir(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MusteriSehirAdapter.ViewHolderMusteriSehir holder, int position) {
        MusteriSehir musteriSehir=musteriSehirArrayList.get(position);
        holder.sehirid.setText(String.valueOf(musteriSehir.getSehiridid()));
        holder.musterisayi.setText(String.valueOf(musteriSehir.getMusterisayisi()));
    }

    @Override
    public int getItemCount() {
        return musteriSehirArrayList.size();
    }

    public class ViewHolderMusteriSehir extends RecyclerView.ViewHolder {
        TextView sehirid;
        TextView musterisayi;

        public ViewHolderMusteriSehir(@NonNull View itemView)
        {
            super(itemView);
            sehirid=itemView.findViewById(R.id.tv_sehirkodd);
            musterisayi=itemView.findViewById(R.id.tv_musterisayisii);

        }
    }
}
