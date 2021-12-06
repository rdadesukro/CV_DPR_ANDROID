package com.example.cv_dpr.adapter;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cv_dpr.R;
import com.example.cv_dpr.model.mobil.DataMobilItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class adapter_sopir extends RecyclerView.Adapter<adapter_sopir.HolderData> {
    private static CountDownTimer countDownTimer;
    String kriim;
    String lat_new,lng_new;
    String lat,lng;
    String jenis;
    private int animation_type = 0;
    private List<DataMobilItem> mList ;
    private Context ctx;
    private OnImageClickListener onImageClickListener;
    public adapter_sopir(Context ctx, List<DataMobilItem> mList , int animation_type, OnImageClickListener onImageClickListener) {
        this.jenis = jenis;
        this.animation_type = animation_type;
        this.mList = mList;
        this.ctx = ctx;
        this.onImageClickListener = onImageClickListener;

    }
    public interface OnImageClickListener {
        void edit(int id, String nama_sopir,String nama,String nopol);
        void hapus(int id);
    }




    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout;
        HolderData holder;
            layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_pemilik_mobil,parent, false);
            holder = new HolderData(layout);

            return holder;
    }


    @SuppressLint("ResourceAsColor")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final HolderData holder, @SuppressLint("RecyclerView") int position) {
        final DataMobilItem dm = mList.get(position);

        holder.txt_nama.setText(dm.getNamaSopir());
       // holder.txt_unit.setText(dm.ge()+" Unit");
        holder.txt_tgl.setText(dm.getCreatedAt());






        holder.dm = dm;
        holder.pos =position;



    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    class HolderData extends  RecyclerView.ViewHolder {


        @BindView(R.id.txt_nama)
        TextView txt_nama;


        @BindView(R.id.txt_tanggal)
        TextView txt_tgl;

        @BindView(R.id.txt_unit)
        TextView txt_unit;



        DataMobilItem dm;
        int pos;


        public HolderData(View v) {
            super(v);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onImageClickListener.edit(dm.getId(),dm.getNamaSopir(), dm.getPemilikMobil().get(0).getNama(),dm.getNopol());
                    Toast.makeText(ctx, ""+dm.getPemilikMobil().get(0).getNama(), Toast.LENGTH_SHORT).show();
                }
            });





//
        }


    }


}
