package com.example.cv_dpr.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.cv_dpr.adapter.adapter_cair;
import com.example.cv_dpr.databinding.ActivityMenuPencairanBinding;
import com.example.cv_dpr.model.pencairan.DataSeotoranItem_cair;
import com.example.cv_dpr.model.trasnportir.DataTransportirItem;
import com.example.cv_dpr.presnter.cair;
import com.example.cv_dpr.view.cair_view;
import com.example.spinner_dialog.OnSpinerItemClick;
import com.example.spinner_dialog.SpinnerDialog;

import java.util.ArrayList;
import java.util.List;

public class menu_pencairan extends AppCompatActivity implements adapter_cair.OnImageClickListener, cair_view {

    com.example.cv_dpr.presnter.cair cair;
    ActivityMenuPencairanBinding bind;
   private adapter_cair adapter_cair;
    SpinnerDialog spinnerDialog;
    String id_trasnportir,nama;
    int id_mobil;
    private List<String> array_nama_trasnportir = new ArrayList<String>();

    private List<Integer> array_transportir_id= new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMenuPencairanBinding.inflate(getLayoutInflater());

        // getting our root layout in our view.
        View view = bind.getRoot();

        // below line is to set
        // Content view for our layout.
        setContentView(view);
        cair = new cair(this,menu_pencairan.this);

        bind.editNamaTrasportir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cair.get_transportir();
            }
        });
        bind.btnCair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cair.get_pencairan(id_mobil);
            }
        });
        bind.btnCekRekap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cair.get_rekapan_pdf(id_mobil,"cek_rekapan");
            }
        });
        bind.swifeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                cair.get_pencairan(id_mobil);

            }
        });

    }

    @Override
    public void edit(int id, String foto, String tanngal_muat, String tanggal_bongkar, String berat_muat, String berat_bongkar, int transportir_id, int harga, String tujuan) {

    }

    @Override
    public void hapus(int id) {

    }

    @Override
    public void sukses(String pesan,String loaksi) {
        Toast.makeText(this, ""+pesan, Toast.LENGTH_SHORT).show();
        Intent ii=new Intent(this, menu_mobil.class);
        ii.putExtra("id", loaksi);
        startActivity(ii);
    }

    @Override
    public void gagal(String pesan) {
        Toast.makeText(this, ""+pesan, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void data_cair(List<DataSeotoranItem_cair> data_cair) {
        try {
            //  Log.i("isi_jawaban", "pertanyaan: " + rekapan);
            // Log.i("cek_data_pertanyaan", "event: " + rekapan.size());
            adapter_cair = new adapter_cair(this, data_cair, 1, this);
            bind.rvAku.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            bind.rvAku.setHasFixedSize(true);
            adapter_cair.notifyDataSetChanged();
            bind.rvAku.setAdapter(adapter_cair);


            bind.swifeRefresh.setRefreshing(false);
            if (data_cair.size() == 0) {
                bind.imgData3.setVisibility(View.VISIBLE);
                bind.txtData4.setVisibility(View.VISIBLE);

                bind.progressBar3.setVisibility(View.GONE);
//
            } else {
                bind.txtData4.setVisibility(View.GONE);
                  bind.imgData3.setVisibility(View.GONE);
                bind.progressBar3.setVisibility(View.GONE);
//

            }
        } catch (Exception e) {

        }
    }

    @Override
    public void transportir(List<DataTransportirItem> transportir) {
        array_nama_trasnportir.clear();
        array_transportir_id.clear();

        for (int i = 0; i < transportir.size(); i++) {
            nama = transportir.get(i).getNamaTransportir();
            id_trasnportir = String.valueOf(transportir.get(i).getId());

            array_nama_trasnportir.add(nama);
            array_transportir_id.add(Integer.valueOf(id_trasnportir));

        }
        spinnerDialog = new SpinnerDialog(menu_pencairan.this, (ArrayList<String>) array_nama_trasnportir, "Pilih Sopir Mobil");
        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                String nama_sop = array_nama_trasnportir.get(position);
                id_mobil = array_transportir_id.get(position);

              bind.editNamaTrasportir.setText(nama_sop);



            }
        });

        if (spinnerDialog == null) {
            // Toast.makeText(ctx, "jaringan bermasalah...", Toast.LENGTH_SHORT);
        } else {
            //finalPDialog.dismiss();
            spinnerDialog.showSpinerDialog("muncul");
            // pd.dismiss();
        }
    }

    @Override
    public void data(String total, String total_do) {
        bind.txtTotol2.setText(total);
    }
}