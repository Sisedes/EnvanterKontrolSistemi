package com.example.envanteryonetimsistemi.SaticiBilgi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.envanteryonetimsistemi.R;
import java.util.ArrayList;


public class SaticiAdapter extends RecyclerView.Adapter<SaticiAdapter.ViewHolderSatici>{
    private ArrayList<Satici> saticiArrayList;
    private Context con;

    public SaticiAdapter(ArrayList<Satici> saticiArrayList,Context con)
    {
        this.saticiArrayList=saticiArrayList;
        this.con=con;
    }
    @NonNull
    @Override
    public SaticiAdapter.ViewHolderSatici onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_tedarikci,parent,false);
        return new SaticiAdapter.ViewHolderSatici(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SaticiAdapter.ViewHolderSatici holder, int position) {
        Satici saticilar=saticiArrayList.get(position);
        holder.satici.setText(String.valueOf(saticilar.getSatici()));
        holder.saticiad.setText(saticilar.getSaticiad());
        holder.telefonno.setText(saticilar.getTelefonno());
        holder.eposta.setText(saticilar.getEposta());
        holder.adres.setText(saticilar.getAdres());
        //holder.sehirid.setText(musteriler.getSehirid());
    }

    @Override
    public int getItemCount() {
        return saticiArrayList.size();
    }

    public class ViewHolderSatici extends RecyclerView.ViewHolder {
        TextView satici;
        TextView saticiad;
        TextView telefonno;
        TextView eposta;
        TextView adres;
        //TextView sehirid;
        public ViewHolderSatici(@NonNull View itemView)
        {
            super(itemView);
            satici=itemView.findViewById(R.id.tv_tedarikciid);
            saticiad=itemView.findViewById(R.id.tv_tedarikciadi);
            telefonno=itemView.findViewById(R.id.tv_tel);
            eposta=itemView.findViewById(R.id.tv_email);
            adres=itemView.findViewById(R.id.tv_adres);
            //sehirid=itemView.findViewById(R.id.tv_deposehirid);
        }
    }
}
