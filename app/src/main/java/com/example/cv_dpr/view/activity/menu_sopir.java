package com.example.cv_dpr.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.cv_dpr.R;
import com.example.cv_dpr.adapter.adapter_sopir;
import com.example.cv_dpr.model.mobil.DataMobilItem;
import com.example.cv_dpr.model.pembyaran.DataKasbonItem;
import com.example.cv_dpr.model.pembyaran.DataPemilikMobilItem_mobil;
import com.example.cv_dpr.model.pembyaran.DataSetoranItem_pembayaran;
import com.example.cv_dpr.model.pembyaran.DataSopirItem_data;
import com.example.cv_dpr.presnter.mobil;
import com.example.cv_dpr.view.mobil_view;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class menu_sopir extends AppCompatActivity implements mobil_view, com.example.cv_dpr.adapter.adapter_sopir.OnImageClickListener {

    private SwipeRefreshLayout swifeRefresh;
    private RecyclerView rvAku;
    private ImageView imgData2;
    private TextView txtData3;
    private ProgressBar progressBar2;
    private FloatingActionButton btnAdd3;
   private com.example.cv_dpr.adapter.adapter_sopir adapter_sopir;
   com.example.cv_dpr.presnter.mobil mobil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sopir);
        initView();
        mobil = new mobil(this,menu_sopir.this);
        mobil.get_sopir();

    }

    private void initView() {
        swifeRefresh = findViewById(R.id.swifeRefresh);
        rvAku = findViewById(R.id.rv_aku);
        imgData2 = findViewById(R.id.img_data2);
        txtData3 = findViewById(R.id.txt_data3);
        progressBar2 = findViewById(R.id.progressBar2);
        btnAdd3 = findViewById(R.id.btn_add3);
    }

    @Override
    public void edit(int id, String nama_sopir,String nama,String nopol) {

    }

    @Override
    public void hapus(int id) {

    }

    @Override
    public void data_sopir(String nama_sopir, String nama_pemilik_mobil, int pemilik_mobil_id, int mobil_id) {

    }

    @Override
    public void sukses(String pesan) {

    }

    @Override
    public void gagal(String pesan) {

    }

    @Override
    public void kasbon(List<DataKasbonItem> kasbon) {

    }

    @Override
    public void pembayaran(List<DataSetoranItem_pembayaran> pembayaran) {

    }

    @Override
    public String data_pembayaran(String totol_setoran, String total_uang_jalan, String total_bersih, String total_kasbon, String total_finis) {
        return null;
    }

    @Override
    public void data_sopir(List<DataSopirItem_data> sopir) {

    }

    @Override
    public void data_sopir_new(List<DataMobilItem> data_sopir_new) {
        try {
            //  Log.i("isi_jawaban", "pertanyaan: " + rekapan);
            // Log.i("cek_data_pertanyaan", "event: " + rekapan.size());
            adapter_sopir = new adapter_sopir(this,data_sopir_new,1,this);
            rvAku.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            rvAku.setHasFixedSize(true);
            adapter_sopir.notifyDataSetChanged();
            rvAku.setAdapter(adapter_sopir);


            swifeRefresh.setRefreshing(false);
            if (data_sopir_new.size() == 0) {
                txtData3.setVisibility(View.VISIBLE);
                imgData2.setVisibility(View.VISIBLE);

                progressBar2.setVisibility(View.GONE);
//
            } else {
                txtData3.setVisibility(View.GONE);
                imgData2.setVisibility(View.GONE);
                progressBar2.setVisibility(View.GONE);
//

            }
        } catch (Exception e) {

        }
    }

    @Override
    public void data_pemilik_mobil(List<DataPemilikMobilItem_mobil> pemilik_mobil) {

    }
}