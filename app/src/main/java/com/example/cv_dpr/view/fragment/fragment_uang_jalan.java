package com.example.cv_dpr.view.fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.cv_dpr.R;
import com.example.cv_dpr.adapter.adapter_uang_jalan;
import com.example.cv_dpr.model.rekapan.DataKasbonItem;
import com.example.cv_dpr.model.rekapan.DataSetoranItem;
import com.example.cv_dpr.presnter.mobil;
import com.example.cv_dpr.presnter.rekapan;
import com.example.cv_dpr.view.mobil_view;
import com.example.cv_dpr.view.rekapan_view;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.net.ssl.SSLContext;

import butterknife.ButterKnife;


public class fragment_uang_jalan extends Fragment implements rekapan_view, adapter_uang_jalan.OnImageClickListener {


    private SwipeRefreshLayout swifeRefresh;
    private RecyclerView rvAku;
    private ImageView imgData;
    private TextView txtData;
    private ProgressBar progressBar4;
    final Calendar myCalendar = Calendar.getInstance();
    com.example.cv_dpr.presnter.rekapan rekapan;
    private adapter_uang_jalan adapter_uang_jalan;
    private TextView txtTotol;
    String tanggal;
    DatePickerDialog.OnDateSetListener tg;
    private FloatingActionButton btnAdd;
    BottomSheetDialog bittom_dialog;
    com.example.cv_dpr.presnter.mobil mobil;
    ProgressDialog pd;
   public EditText edit_nama_sopir, edit_nama_pemilik_mobil;
    public fragment_uang_jalan() {
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
        View view = inflater.inflate(R.layout.activity_menu_uang_jalan, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        try {
            ProviderInstaller.installIfNeeded(getContext());
            SSLContext sslContext;
            sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, null, null);
            sslContext.createSSLEngine();
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException
                | NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date(System.currentTimeMillis());
        tanggal = formatter.format(date);
        updateLabel();
        rekapan = new rekapan(this, getActivity());
        rekapan.get_uang_jalan(tanggal);
        tg = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
                Log.i("isi_tanggal", "onCreateView: " + tanggal);
                rekapan.get_uang_jalan(tanggal);

            }

        };


        swifeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                rekapan.get_uang_jalan(tanggal);

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("jenis","new");

                fragment_add_edit_uang_jalan newFragment = new fragment_add_edit_uang_jalan();
                newFragment.setArguments(args);
                newFragment.show(getActivity().getSupportFragmentManager(), "TAG");

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
        btnAdd = v.findViewById(R.id.btn_add);
    }

    @Override
    public void rekapan(List<DataSetoranItem> rekapan) {
        try {
            Log.i("isi_jawaban", "pertanyaan: " + rekapan);
            Log.i("cek_data_pertanyaan", "event: " + rekapan.size());
            adapter_uang_jalan = new adapter_uang_jalan(getActivity(), rekapan, 1, this);
            rvAku.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            rvAku.setHasFixedSize(true);
            adapter_uang_jalan.notifyDataSetChanged();
            rvAku.setAdapter(adapter_uang_jalan);


            swifeRefresh.setRefreshing(false);
            if (rekapan.size() == 0) {
                progressBar4.setVisibility(View.GONE);
                imgData.setVisibility(View.VISIBLE);
                txtData.setVisibility(View.VISIBLE);
            } else {
                progressBar4.setVisibility(View.GONE);
                imgData.setVisibility(View.GONE);
                txtData.setVisibility(View.GONE);
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
    public void edit(int id, int id_sopir,int uang_jalan,int id_pemilik_mobil,String nama_sopir,String nama_pemilik_mobil) {
//        fragment_add_edit_uang_jalan dialog1 = new fragment_add_edit_uang_jalan(nama_sopir,nama_sopir);
//        dialog1.setTargetFragment(fragment_uang_jalan.this, 22); // in case of fragment to activity communication we do not need this line. But must write this i case of fragment to fragment communication
//        dialog1.show(getFragmentManager(), "fragment_camera");
        Bundle args = new Bundle();
        args.putString("id", String.valueOf(id));
        args.putString("id_sopir", String.valueOf(id_sopir));
        args.putString("uang_jalan", String.valueOf(uang_jalan));
        args.putString("id_pemilik_mobil", String.valueOf(id_pemilik_mobil));
        args.putString("nama_sopir",nama_sopir);
        args.putString("nama_pemilik_mobil",nama_pemilik_mobil);
        args.putString("jenis","edit");

        fragment_add_edit_uang_jalan newFragment = new fragment_add_edit_uang_jalan();
        newFragment.setArguments(args);
        newFragment.show(getActivity().getSupportFragmentManager(), "TAG");

    }

    @Override
    public void hapus(int id) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.filter, menu);
        MenuItem refres = menu.findItem(R.id.setting);
        refres.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                new DatePickerDialog(getActivity(), tg, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void updateLabel() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        tanggal = sdf.format(myCalendar.getTime());
    }



}