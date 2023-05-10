package com.example.envanteryonetimsistemi.ViewTedarikciUrun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.envanteryonetimsistemi.R;

import java.util.ArrayList;

public class TedarikciUrunAdapter extends RecyclerView.Adapter<TedarikciUrunAdapter.ViewHolderTedarikciUrun> {

    private ArrayList<TedarikciUrun> tedarikciUrunArrayList;
    private Context con;

    public TedarikciUrunAdapter(ArrayList<TedarikciUrun> tedarikciUrunArrayList,Context con)
    {
        this.tedarikciUrunArrayList=tedarikciUrunArrayList;
        this.con=con;
    }
    @NonNull

    @Override
    public TedarikciUrunAdapter.ViewHolderTedarikciUrun onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_tedarikciurun,parent,false);
        return new TedarikciUrunAdapter.ViewHolderTedarikciUrun(view);
    }



    @Override
    public void onBindViewHolder(@NonNull TedarikciUrunAdapter.ViewHolderTedarikciUrun holder, int position) {
        TedarikciUrun tedarikciUrun=tedarikciUrunArrayList.get(position);
        holder.saticiad.setText(String.valueOf(tedarikciUrun.getSaticiad()));
        holder.urunad.setText(String.valueOf(tedarikciUrun.getUrunismi()));
        holder.fiyat.setText(String.valueOf(tedarikciUrun.getFiyat()));
    }

    @Override
    public int getItemCount() {
        return tedarikciUrunArrayList.size();
    }

    public class ViewHolderTedarikciUrun extends RecyclerView.ViewHolder {
        TextView saticiad;
        TextView urunad;
        TextView fiyat;
        public ViewHolderTedarikciUrun(@NonNull View itemView)
        {
            super(itemView);
            saticiad=itemView.findViewById(R.id.tv_tedarikciadii);
            urunad=itemView.findViewById(R.id.tv_urunadii);
            fiyat=itemView.findViewById(R.id.tv_fiyatt);

        }
    }
}
