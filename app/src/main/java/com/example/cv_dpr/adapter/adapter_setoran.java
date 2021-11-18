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

import androidx.recyclerview.widget.RecyclerView;

import com.example.cv_dpr.R;
import com.example.cv_dpr.model.rekapan.DataSetoranItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class adapter_setoran extends RecyclerView.Adapter<adapter_setoran.HolderData> {
    private static CountDownTimer countDownTimer;
    String kriim;
    String lat_new,lng_new;
    String lat,lng;
    String jenis;
    private int animation_type = 0;
    private List<DataSetoranItem> mList ;
    private Context ctx;
    private OnImageClickListener onImageClickListener;
    public adapter_setoran(Context ctx, List<DataSetoranItem> mList , int animation_type, OnImageClickListener onImageClickListener) {
        this.jenis = jenis;
        this.animation_type = animation_type;
        this.mList = mList;
        this.ctx = ctx;
        this.onImageClickListener = onImageClickListener;

    }
    public interface OnImageClickListener {
        void edit(int id, String nama_sopir,int uang_jalan);
        void hapus(int id);
    }




    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout;
        HolderData holder;
            layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_setoran,parent, false);
            holder = new HolderData(layout);

            return holder;
    }


    @SuppressLint("ResourceAsColor")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final HolderData holder, @SuppressLint("RecyclerView") int position) {
        final DataSetoranItem dm = mList.get(position);

        holder.txt_nama.setText(dm.getMobil().getNamaSopir());
        holder.txt_uang_jalan.setText(""+dm.getUang_jalan_new());
        holder.txt_tgl.setText(dm.getTglAmbilUangJalan());
        holder.txt_tujuan.setText(dm.getTujuan());
        holder.txt_total_bersih.setText(dm.getJumlah_bersih_new());
        holder.txt_total_kotor.setText(dm.getJumlah_kotor_new());
        holder.txt_status.setText(dm.getStatus());



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


        @BindView(R.id.txt_tgl)
        TextView txt_tgl;

        @BindView(R.id.txt_uang_jalan)
        TextView txt_uang_jalan;

        @BindView(R.id.txt_total_kotor)
        TextView txt_total_kotor;

        @BindView(R.id.txt_total_bersih)
        TextView txt_total_bersih;

        @BindView(R.id.txt_tujuan)
        TextView txt_tujuan;

        @BindView(R.id.txt_status)
        TextView txt_status;



        DataSetoranItem dm;
        int pos;


        public HolderData(View v) {
            super(v);
            ButterKnife.bind(this, itemView);
//            img_gambar.setOnClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//
//
//                    return false;
//                }
//            });




//
        }


    }


}
