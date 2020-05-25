package id.co.blogbasbas.wisatasemarang.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import id.co.blogbasbas.wisatasemarang.DetailsActivity;
import id.co.blogbasbas.wisatasemarang.Konstanta;
import id.co.blogbasbas.wisatasemarang.R;
import id.co.blogbasbas.wisatasemarang.model.WisataModel;

/**
 * Created by Server on 30/10/2017.
 */

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.MyHolder>{


    private ArrayList<WisataModel> listData;
    private Context context;

    public WisataAdapter(ArrayList<WisataModel> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }


    @Override
    public WisataAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_wisata, parent, false);
        MyHolder holder = new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(WisataAdapter.MyHolder holder, final int position) {
        holder.tv1.setText(listData.get(position).getNamaWisata());
        holder.tv2.setText(listData.get(position).getAlamatWisata());
        Picasso.with(context).load(Konstanta.BASEURL_IMAGE+listData.get(position).getGambarWisata())
                .placeholder(R.drawable.olele)
                .error(R.drawable.olele)
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(context, DetailsActivity.class);
                Bundle data = new Bundle();
                data.putString(Konstanta.DATA_ID, listData.get(position).getIdWisata());
                data.putString(Konstanta.DATA_NAMA, listData.get(position).getNamaWisata());
                data.putString(Konstanta.DATA_GAMBAR, listData.get(position).getGambarWisata());
                data.putString(Konstanta.DATA_DESKRIPSI, listData.get(position).getDeksripsiWisata());
                data.putString(Konstanta.DATA_ALAMAT, listData.get(position).getAlamatWisata());
                data.putString(Konstanta.DATA_LAT, listData.get(position).getLatitudeWisata());
                data.putString(Konstanta.DATA_LNG, listData.get(position).getLongitudeWisata());
                data.putString(Konstanta.DATA_GBR1, listData.get(position).getGambar1());
                data.putString(Konstanta.DATA_GBR2, listData.get(position).getGambar2());
                data.putString(Konstanta.DATA_GBR3, listData.get(position).getGambar3());
                data.putString(Konstanta.DATA_GBR4, listData.get(position).getGambar4());


                pindah.putExtras(data);
                context.startActivity(pindah);
            }
        });

        //    Picasso.with(context).load(data_wisata.get(position).getGambarWisata().in
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
      ImageView imageView;
        TextView tv1, tv2;


        public MyHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imgWisata);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv2 =(TextView) itemView.findViewById(R.id.tv2);

        }
    }
}
