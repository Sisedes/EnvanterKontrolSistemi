package com.example.envanteryonetimsistemi.ViewDepoUrun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.envanteryonetimsistemi.R;

import java.util.ArrayList;

public class DepoUrunAdapter extends RecyclerView.Adapter<DepoUrunAdapter.ViewHolderDepoUrun> {

    private ArrayList<DepoUrun> depoUrunArrayList;
    private Context con;

    public DepoUrunAdapter(ArrayList<DepoUrun> depoUrunArrayList,Context con)
    {
        this.depoUrunArrayList=depoUrunArrayList;
        this.con=con;
    }
    @NonNull

    @Override
    public DepoUrunAdapter.ViewHolderDepoUrun onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_depourun,parent,false);
        return new DepoUrunAdapter.ViewHolderDepoUrun(view);
    }



    @Override
    public void onBindViewHolder(@NonNull DepoUrunAdapter.ViewHolderDepoUrun holder, int position) {
        DepoUrun depoUrun=depoUrunArrayList.get(position);
        holder.depoid.setText(String.valueOf(depoUrun.getDepoid()));
        holder.urunid.setText(String.valueOf(depoUrun.getUrunid()));
        holder.urunad.setText(String.valueOf(depoUrun.getUrunisim()));
    }

    @Override
    public int getItemCount() {
        return depoUrunArrayList.size();
    }

    public class ViewHolderDepoUrun extends RecyclerView.ViewHolder {
        TextView depoid;
        TextView urunid;
        TextView urunad;
        public ViewHolderDepoUrun(@NonNull View itemView)
        {
            super(itemView);
            depoid=itemView.findViewById(R.id.tv_depoidd);
            urunid=itemView.findViewById(R.id.tv_urunidd);
            urunad=itemView.findViewById(R.id.tv_urunadiii);

        }
    }
}
