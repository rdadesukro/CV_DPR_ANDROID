package com.example.cv_dpr.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.cv_dpr.R;
import com.example.cv_dpr.view.activity.menu_pembayaran;
import com.example.cv_dpr.view.activity.menu_pemilik_mobil;
import com.example.cv_dpr.view.activity.menu_sopir;
import com.example.cv_dpr.view.activity.menu_transportir;

import butterknife.ButterKnife;


public class fragment_home extends Fragment {


    private CardView cardPustaka;
    private CardView cardAbsen;
    private CardView cardTugas;
    private CardView cardMateri;
    private CardView cardBayar;

    public fragment_home() {
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
        View view = inflater.inflate(R.layout.activity_menu_home, container, false);
        ButterKnife.bind(this, view);
        initView(view);

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
        cardPustaka = v.findViewById(R.id.card_pustaka);
        cardAbsen = v.findViewById(R.id.card_absen);
        cardTugas = v.findViewById(R.id.card_tugas);
        cardMateri = v.findViewById(R.id.card_materi);
        cardBayar =  v.findViewById(R.id.card_bayar);
        cardTugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent materi = new Intent(getActivity(), menu_sopir.class);
                startActivity(materi);
            }
        });
        cardMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent materi = new Intent(getActivity(), menu_pemilik_mobil.class);
                startActivity(materi);
            }
        });
        cardBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent materi = new Intent(getActivity(), menu_pembayaran.class);
                startActivity(materi);
            }
        });
        cardAbsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent materi = new Intent(getActivity(), menu_transportir.class);
                startActivity(materi);
            }
        });

    }
}