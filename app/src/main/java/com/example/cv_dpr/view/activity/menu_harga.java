package com.example.cv_dpr.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.cv_dpr.R;
import com.example.cv_dpr.adapter.adapter_cair;
import com.example.cv_dpr.adapter.adapter_harga;
import com.example.cv_dpr.databinding.ActivityMenuHargaBinding;
import com.example.cv_dpr.databinding.ActivityMenuPencairanBinding;
import com.example.cv_dpr.model.tujuan.DataHargaItem_tujan;
import com.example.cv_dpr.presnter.cair;
import com.example.cv_dpr.presnter.tujuan;
import com.example.cv_dpr.view.tujuan_view;

import java.util.List;

public class menu_harga extends AppCompatActivity implements tujuan_view, adapter_harga.OnImageClickListener {
    com.example.cv_dpr.presnter.tujuan tujuan;
    ActivityMenuHargaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuHargaBinding.inflate(getLayoutInflater());

        // getting our root layout in our view.
        View view = binding.getRoot();

        // below line is to set
        // Content view for our layout.
        setContentView(view);
        tujuan = new tujuan(this,menu_harga.this);
        tujuan.get_tujuan();

        binding.rvAku.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.i("isi_rvku", "onScrolled: " + dx + " " + dy);
                if (dy > 0 &&   binding.btnAdd3.getVisibility() == View.VISIBLE) {
                    binding.btnAdd3.hide();
                } else if (dy < 0 &&   binding.btnAdd3.getVisibility() != View.VISIBLE) {
                    binding.btnAdd3.show();
                }
            }
        });

    }

    @Override
    public void edit(int id, String tujuan, int harga, String tgl, int tranportir_id, String transportir_nama) {

    }

    @Override
    public void hapus(int id) {

    }

    @Override
    public void tujuan(List<DataHargaItem_tujan> tujuan) {
        try {
            //  Log.i("isi_jawaban", "pertanyaan: " + rekapan);
            // Log.i("cek_data_pertanyaan", "event: " + rekapan.size());
            com.example.cv_dpr.adapter.adapter_harga adapter_harga = new adapter_harga(this, tujuan, 1, this);
            binding .rvAku.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            binding.rvAku.setHasFixedSize(true);
            adapter_harga.notifyDataSetChanged();
            binding.rvAku.setAdapter(adapter_harga);


            binding.swifeRefresh.setRefreshing(false);
            if (tujuan.size() == 0) {
                binding.imgData2.setVisibility(View.VISIBLE);
                binding.txtData3.setVisibility(View.VISIBLE);

                binding.progressBar2.setVisibility(View.GONE);
//
            } else {
                binding.txtData3.setVisibility(View.GONE);
                binding.imgData2.setVisibility(View.GONE);
                binding.progressBar2.setVisibility(View.GONE);
//

            }
        } catch (Exception e) {

        }
    }
}