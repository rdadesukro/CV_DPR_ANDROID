package com.example.cv_dpr.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.cv_dpr.R;
import com.example.cv_dpr.adapter.adapter_kasbon;
import com.example.cv_dpr.adapter.adapter_pembayaran;
import com.example.cv_dpr.model.pembyaran.DataKasbonItem;
import com.example.cv_dpr.model.pembyaran.DataSetoranItem_pembayaran;
import com.example.cv_dpr.model.rekapan.DataSetoranItem;
import com.example.cv_dpr.presnter.mobil;
import com.example.cv_dpr.view.mobil_view;
import com.example.cv_dpr.view.rekapan_view;

import java.util.List;

public class menu_data_pembayaran extends AppCompatActivity implements mobil_view, rekapan_view {

    private ConstraintLayout relativeLayout;
    private SwipeRefreshLayout swifeRefresh;
    private NestedScrollView nestedScrollView3;
    private CardView cardEvent;
    private ProgressBar progEvent;
    private ImageView btnEvent;
    private TextView textView3;
    private CardView cardBerita;
    private ImageView btnKasbon;
    private ConstraintLayout conKasbon;
    private ProgressBar progKasbon;
    private RecyclerView rvKasbon;
    private CardView cardLokasi;
    private ImageView btnSetoran;
    private ProgressBar progSetoran;
    private RecyclerView rvSetoran;

    com.example.cv_dpr.presnter.mobil mobil;
    com.example.cv_dpr.presnter.rekapan rekapan;
    String id, jenis, waktu, from, to;
    private com.example.cv_dpr.adapter.adapter_kasbon adapter_kasbon;
    private com.example.cv_dpr.adapter.adapter_pembayaran adapter_pembayaran;
    private WebView webData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_data_pembayaran);
        initView();
        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null) {
            id = (String) b.get("id");
            jenis = (String) b.get("jenis");
            waktu = (String) b.get("waktu");
            from = (String) b.get("from");
            to = (String) b.get("to");


        }
        mobil = new mobil(this, menu_data_pembayaran.this);
        mobil.get_rekapan(id, jenis, waktu, from, to);
    }

    private void initView() {
        relativeLayout = findViewById(R.id.relativeLayout);
        swifeRefresh = findViewById(R.id.swifeRefresh);
        nestedScrollView3 = findViewById(R.id.nestedScrollView3);
        cardEvent = findViewById(R.id.card_event);
        progEvent = findViewById(R.id.prog_event);
        btnEvent = findViewById(R.id.btn_event);
        textView3 = findViewById(R.id.textView3);
        cardBerita = findViewById(R.id.card_berita);
        btnKasbon = findViewById(R.id.btn_kasbon);
        conKasbon = findViewById(R.id.con_kasbon);
        progKasbon = findViewById(R.id.prog_kasbon);
        rvKasbon = findViewById(R.id.rv_kasbon);
        cardLokasi = findViewById(R.id.card_lokasi);
        btnSetoran = findViewById(R.id.btn_setoran);
        progSetoran = findViewById(R.id.prog_setoran);
        rvSetoran = findViewById(R.id.rv_setoran);
        webData = findViewById(R.id.web_data);
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
        try {
            Log.i("isi_jawaban", "pertanyaan: " + rekapan);
            // Log.i("cek_data_pertanyaan", "event: " + rekapan.size());
            adapter_kasbon = new adapter_kasbon(this, kasbon, 1, null);
            rvKasbon.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            rvKasbon.setHasFixedSize(true);
            adapter_kasbon.notifyDataSetChanged();
            rvKasbon.setAdapter(adapter_kasbon);


            swifeRefresh.setRefreshing(false);
            if (kasbon.size() == 0) {

                progKasbon.setVisibility(View.VISIBLE);
//
            } else {
                progKasbon.setVisibility(View.GONE);
//

            }
        } catch (Exception e) {

        }
    }

    @Override
    public void pembayaran(List<DataSetoranItem_pembayaran> pembayaran) {
        try {
            Log.i("isi_jawaban", "pertanyaan: " + rekapan);
            // Log.i("cek_data_pertanyaan", "event: " + rekapan.size());
            adapter_pembayaran = new adapter_pembayaran(this, pembayaran, 1, null);
            rvSetoran.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            rvSetoran.setHasFixedSize(true);
            adapter_pembayaran.notifyDataSetChanged();
            rvSetoran.setAdapter(adapter_pembayaran);


            swifeRefresh.setRefreshing(false);
            if (pembayaran.size() == 0) {

                progSetoran.setVisibility(View.VISIBLE);
//
            } else {
                progSetoran.setVisibility(View.GONE);
//

            }
        } catch (Exception e) {

        }
    }

    @Override
    public void rekapan(List<DataSetoranItem> rekapan) {

    }

    @Override
    public void total_uang_jalan(String totol) {

    }

}