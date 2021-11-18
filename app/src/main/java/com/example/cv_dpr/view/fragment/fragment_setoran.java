package com.example.cv_dpr.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.cv_dpr.R;
import com.example.cv_dpr.adapter.adapter_setoran;
import com.example.cv_dpr.adapter.adapter_uang_jalan;
import com.example.cv_dpr.model.rekapan.DataKasbonItem;
import com.example.cv_dpr.model.rekapan.DataSetoranItem;
import com.example.cv_dpr.presnter.rekapan;
import com.example.cv_dpr.view.rekapan_view;

import java.util.List;

import butterknife.ButterKnife;


public class fragment_setoran extends Fragment implements rekapan_view, adapter_setoran.OnImageClickListener {


    private SwipeRefreshLayout swifeRefresh;
    private RecyclerView rvAku;
    private ImageView imgData;
    private TextView txtData;
    private ProgressBar progressBar4;

    com.example.cv_dpr.presnter.rekapan rekapan;
    private adapter_setoran adapter_setoran;
    private TextView txtTotol;

    public fragment_setoran() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu_setoran, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        rekapan = new rekapan(this, getActivity());
        rekapan.get_setoran();

        swifeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                rekapan.get_setoran();

            }
        });

        return view;


    }

    @Override
    public void onResume() {
        super.onResume();


    }


    @Override
    public void onStart() {
        super.onStart();

    }

    private void initView(View v) {
        swifeRefresh = (SwipeRefreshLayout) v.findViewById(R.id.swifeRefresh);
        rvAku = (RecyclerView) v.findViewById(R.id.rv_aku);
        imgData = (ImageView) v.findViewById(R.id.img_data);
        txtData = (TextView) v.findViewById(R.id.txt_data);
        progressBar4 = (ProgressBar) v.findViewById(R.id.progressBar4);
        txtTotol = (TextView) v.findViewById(R.id.txt_totol);
    }



    @Override
    public void rekapan(List<DataSetoranItem> rekapan) {
        try {
            Log.i("isi_jawaban", "pertanyaan: " + rekapan);
            Log.i("cek_data_pertanyaan", "event: " + rekapan.size());
             adapter_setoran = new adapter_setoran(getActivity(), rekapan, 1, this);
            rvAku.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            rvAku.setHasFixedSize(true);
            adapter_setoran.notifyDataSetChanged();
            rvAku.setAdapter(adapter_setoran);


            swifeRefresh.setRefreshing(false);
            if (rekapan.size() == 0) {
                progressBar4.setVisibility(View.VISIBLE);
                //  cardEvent.setVisibility(View.GONE);
            } else {
                progressBar4.setVisibility(View.GONE);
                // cardEvent.setVisibility(View.VISIBLE);

            }
        } catch (Exception e) {

        }

    }

    @Override
    public void total_uang_jalan(String totol) {
        txtTotol.setText(totol);
    }

    @Override
    public void kasbon(List<DataKasbonItem> kasbon) {

    }

    @Override
    public void edit(int id, String nama_sopir, int uang_jalan) {

    }

    @Override
    public void hapus(int id) {

    }
}