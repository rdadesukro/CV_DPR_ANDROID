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
import com.example.cv_dpr.adapter.adapter_pemilik_mobil;
import com.example.cv_dpr.model.pemilik_mobil.DataPemilikMobilItem;
import com.example.cv_dpr.presnter.pemilik_mobil;
import com.example.cv_dpr.view.fragment.fragment_add_edit_pemilik_mobil;
import com.example.cv_dpr.view.pemilik_mobil_view;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class menu_pemilik_mobil extends AppCompatActivity implements pemilik_mobil_view,adapter_pemilik_mobil.OnImageClickListener {

    com.example.cv_dpr.presnter.pemilik_mobil pemilik_mobil;
    private com.example.cv_dpr.adapter.adapter_pemilik_mobil adapter_pemilik_mobil;
    private SwipeRefreshLayout swifeRefresh;
    private RecyclerView rvAku;
    private ImageView imgData2;
    private TextView txtData3;
    private ProgressBar progressBar2;
    private FloatingActionButton btnAdd3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pemilik_mobil);
        initView();
        pemilik_mobil = new pemilik_mobil(this,menu_pemilik_mobil.this);
        pemilik_mobil.get_pemilik_mobil();
    }

    @Override
    public void sukses(String pesan) {

    }

    @Override
    public void gagal(String pesan) {

    }

    @Override
    public void pemilik_mobil(List<DataPemilikMobilItem> pemilik_mobil) {
        try {
          //  Log.i("isi_jawaban", "pertanyaan: " + rekapan);
            // Log.i("cek_data_pertanyaan", "event: " + rekapan.size());
           adapter_pemilik_mobil = new adapter_pemilik_mobil(this, pemilik_mobil, 1, this);
            rvAku.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            rvAku.setHasFixedSize(true);
            adapter_pemilik_mobil.notifyDataSetChanged();
            rvAku.setAdapter(adapter_pemilik_mobil);


            swifeRefresh.setRefreshing(false);
            if (pemilik_mobil.size() == 0) {
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

    private void initView() {
        swifeRefresh = findViewById(R.id.swifeRefresh);
        rvAku = findViewById(R.id.rv_aku);
        imgData2 = findViewById(R.id.img_data2);
        txtData3 = findViewById(R.id.txt_data3);
        progressBar2 = findViewById(R.id.progressBar2);
        btnAdd3 = findViewById(R.id.btn_add3);
        btnAdd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle args = new Bundle();
                args.putString("jenis", "new");
                fragment_add_edit_pemilik_mobil newFragment = new fragment_add_edit_pemilik_mobil();
                newFragment.setArguments(args);
                newFragment.show(getSupportFragmentManager(), "TAG");

            }
        });
    }

    @Override
    public void edit(int id, String nama, String jumlah_unit) {
        Bundle args = new Bundle();
        args.putString("jenis", "edit");
        args.putString("nama", nama);
        args.putString("jumlah_unit",jumlah_unit);
        args.putString("id", String.valueOf(id));
        fragment_add_edit_pemilik_mobil newFragment = new fragment_add_edit_pemilik_mobil();
        newFragment.setArguments(args);
        newFragment.show(getSupportFragmentManager(), "TAG");
    }

    @Override
    public void hapus(int id) {

    }
}