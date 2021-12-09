package com.example.cv_dpr.view.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.cv_dpr.adapter.adapter_trasportir;
import com.example.cv_dpr.databinding.ActivityMenuTransportirBinding;
import com.example.cv_dpr.model.trasnportir.DataTransportirItem;
import com.example.cv_dpr.presnter.trasnportir;
import com.example.cv_dpr.view.trasnportir_view;

import java.util.List;

public class menu_transportir extends AppCompatActivity implements trasnportir_view, adapter_trasportir.OnImageClickListener {
    com.example.cv_dpr.presnter.trasnportir trasnportir;
    private adapter_trasportir adapter_trasportir;


    ActivityMenuTransportirBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        bind = ActivityMenuTransportirBinding.inflate(getLayoutInflater());

        // getting our root layout in our view.
        View view = bind.getRoot();

        // below line is to set
        // Content view for our layout.
        setContentView(view);
        trasnportir = new trasnportir(this,menu_transportir.this);
        trasnportir.get_trasnporir();


    }

    @Override
    public void data_transportir(String nama, int id) {

    }

    @Override
    public void sukses(String pesan) {

    }

    @Override
    public void gagal(String pesan) {

    }

    @Override
    public void transportir(List<DataTransportirItem> transportir) {
        try {
            //  Log.i("isi_jawaban", "pertanyaan: " + rekapan);
            // Log.i("cek_data_pertanyaan", "event: " + rekapan.size());
            adapter_trasportir = new adapter_trasportir(this, transportir, 1, this);
            bind.rvAku.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            bind.rvAku.setHasFixedSize(true);
            adapter_trasportir.notifyDataSetChanged();
            bind.rvAku.setAdapter(adapter_trasportir);


            bind.swifeRefresh.setRefreshing(false);
            if (transportir.size() == 0) {
                bind.txtData3.setVisibility(View.VISIBLE);
                bind.imgData2.setVisibility(View.VISIBLE);

                bind.progressBar2.setVisibility(View.GONE);
//
            } else {
                bind.txtData3.setVisibility(View.GONE);
                bind.imgData2.setVisibility(View.GONE);
                bind.progressBar2.setVisibility(View.GONE);
//

            }

        }catch (Exception e){

        }


    }

    @Override
    public void edit(int id, String nama) {

    }

    @Override
    public void hapus(int id) {

    }
}