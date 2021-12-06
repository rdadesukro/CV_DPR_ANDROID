package com.example.cv_dpr.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
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
import com.example.cv_dpr.model.mobil.DataMobilItem;
import com.example.cv_dpr.model.pembyaran.DataKasbonItem;
import com.example.cv_dpr.model.pembyaran.DataPemilikMobilItem_mobil;
import com.example.cv_dpr.model.pembyaran.DataSetoranItem_pembayaran;
import com.example.cv_dpr.model.pembyaran.DataSopirItem_data;
import com.example.cv_dpr.model.rekapan.DataSetoranItem;
import com.example.cv_dpr.presnter.mobil;
import com.example.cv_dpr.view.mobil_view;
import com.example.cv_dpr.view.rekapan_view;

import java.util.ArrayList;
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
    String nama_pemilik_mobil;
    public static List<String> nama_Sopir = new ArrayList<String>();
    private TextView txtData2;
    private ImageView imgDataKasbon;
    private TextView txtDataDo;
    private ImageView imgDataDo;

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
        txtData2 = findViewById(R.id.txt_data2);
        imgDataKasbon = findViewById(R.id.img_data_kasbon);
        txtDataDo = findViewById(R.id.txt_data_do);
        imgDataDo = findViewById(R.id.img_data_do);
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
                txtData2.setVisibility(View.VISIBLE);
                imgDataKasbon.setVisibility(View.VISIBLE);
                progKasbon.setVisibility(View.GONE);
//
            } else {
                txtData2.setVisibility(View.GONE);
                imgDataKasbon.setVisibility(View.GONE);
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
                txtDataDo.setVisibility(View.VISIBLE);
                imgDataDo.setVisibility(View.VISIBLE);

                progSetoran.setVisibility(View.GONE);
//
            } else {
                txtDataDo.setVisibility(View.GONE);
                imgDataDo.setVisibility(View.GONE);
                progSetoran.setVisibility(View.GONE);
//

            }
        } catch (Exception e) {

        }
    }

    @Override
    public String data_pembayaran(String totol_setoran, String total_uang_jalan, String total_bersih, String total_kasbon, String total_finis) {

        String myTable = "<table border=0>" +
                "<tr>" +
                "<td>Nama Pemilik Mobil</td>" +
                "<td>:</td>" +
                "<td>" + nama_pemilik_mobil + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>Nama Sopir</td>" +
                "<td>:</td>" +
                "<td>" + nama_Sopir + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>Total Setoran DO</td>" +
                "<td>:</td>" +
                "<td>" + totol_setoran + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>Total Uang Jalan</td>" +
                "<td>:</td>" +
                "<td>" + total_uang_jalan + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>Total Bersih</td>" +
                "<td>:</td>" +
                "<td>" + total_bersih + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>Total Kasbon</td>" +
                "<td>:</td>" +
                "<td>" + total_kasbon + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>Total Final</td>" +
                "<td>:</td>" +
                "<td>" + total_finis + "</td>" +
                "</tr>" +
                "</table>";

        webData.requestFocus();
        webData.getSettings().setLightTouchEnabled(true);
        webData.getSettings().setJavaScriptEnabled(true);
        webData.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webData.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        // webData.loadDataWithBaseURL("","<style>img{display: inline;height: auto;max-width: 100%;}</style>"+ text, "text/html", "UTF-8", "");
        webData.loadDataWithBaseURL(null, myTable, "text/html", "utf-8", null);
        return null;
    }

    @Override
    public void data_sopir(List<DataSopirItem_data> sopir) {
        nama_Sopir.clear();

        for (int i = 0; i < sopir.size(); i++) {
            nama_Sopir.add(sopir.get(i).getNamaSopir());
            //   nama_Sopir.set(i,sopir.get(i).getNamaSopir());
        }
        Log.i("data_nama", "data_sopir: " + nama_Sopir);


    }

    @Override
    public void data_sopir_new(List<DataMobilItem> data_sopir_new) {

    }

    @Override
    public void data_pemilik_mobil(List<DataPemilikMobilItem_mobil> pemilik_mobil) {
        nama_pemilik_mobil = pemilik_mobil.get(0).getNama();
    }

    @Override
    public void rekapan(List<DataSetoranItem> rekapan) {

    }

    @Override
    public void total_uang_jalan(String totol) {

    }

}