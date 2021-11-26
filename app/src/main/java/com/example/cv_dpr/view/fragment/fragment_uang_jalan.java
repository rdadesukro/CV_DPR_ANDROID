package com.example.cv_dpr.view.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

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
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.net.ssl.SSLContext;

import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;


public class fragment_uang_jalan extends Fragment implements mobil_view, rekapan_view, adapter_uang_jalan.OnImageClickListener {


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
    BottomSheetDialog dialog;
    String cari = "";

    String jenis = "semua", filter, tahun = "";
    com.example.cv_dpr.presnter.mobil mobil;
    MaterialButtonToggleGroup btn_grup;
    String id_sopir_new, nama_sopir_new;
    private ConstraintLayout conCari;
    private EditText editNamaSopir;
    private Button btnCari;
    private TextView textView10;
    private EditText editTanggal;
    private ImageView btnShow;
    private RadioGroup radioGroup;
    private RadioButton rdSemua;
    private RadioButton rdTnggal;
    private RadioButton rdKemarin;
    private TextInputLayout txtTgl;
    private TextView textView;

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
        btnShow.setBackgroundResource(R.drawable.ic_baseline_arrow_drop_down_24);
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
        mobil = new mobil(this, getActivity());
        rekapan = new rekapan(this, getActivity());
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
                //  rekapan.get_uang_jalan(tanggal, cari, jenis, id_sopir_new);

            }

        };


        swifeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                rekapan.get_uang_jalan(tanggal, cari, jenis, id_sopir_new);

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("jenis", "new");
                fragment_add_edit_uang_jalan newFragment = new fragment_add_edit_uang_jalan();
                newFragment.setArguments(args);
                newFragment.show(getActivity().getSupportFragmentManager(), "TAG");

            }
        });


        rvAku.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.i("isi_rvku", "onScrolled: " + dx + " " + dy);
                if (dy > 0 && btnAdd.getVisibility() == View.VISIBLE) {
                    btnAdd.hide();
                } else if (dy < 0 && btnAdd.getVisibility() != View.VISIBLE) {
                    btnAdd.show();
                }
            }
        });

        editNamaSopir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobil.get_mobil();
            }
        });

        editTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jenis = "tanggal";
                new DatePickerDialog(getActivity(), tg, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rd_semua:
                        jenis = "semua";
                        txtTgl.setVisibility(View.GONE);
                        break;
                    case R.id.rd_kemarin:
                        jenis = "kemarin";
                        txtTgl.setVisibility(View.GONE);
                        break;
                    case R.id.rd_tnggal:
                        jenis = "tanggal";
                        txtTgl.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jenis.equals("tanggal")) {
                    if (editNamaSopir.getText().toString().trim().equals("")) {
                        Toasty.error(getActivity(), "Nama Sopir Harus Di Isi", Toast.LENGTH_SHORT, true).show();
                    } else if (editTanggal.getText().toString().trim().equals("")) {
                        Toasty.error(getActivity(), "Tanggal Harus Di Isi", Toast.LENGTH_SHORT, true).show();
                    } else {
                        rekapan.get_uang_jalan(tanggal, cari, jenis, id_sopir_new);
                    }
                } else {
                    if (editNamaSopir.getText().toString().trim().equals("")) {
                        Toasty.error(getActivity(), "Nama Sopir Harus Di Isi", Toast.LENGTH_SHORT, true).show();
                    } else {
                        rekapan.get_uang_jalan(tanggal, cari, jenis, id_sopir_new);
                    }
                }


            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (conCari.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(conCari, new AutoTransition());
                    conCari.setVisibility(View.VISIBLE);
                    btnShow.setBackgroundResource(R.drawable.ic_baseline_arrow_drop_up_24);

                } else {
                    TransitionManager.beginDelayedTransition(conCari, new AutoTransition());
                    conCari.setVisibility(View.GONE);
                    btnShow.setBackgroundResource(R.drawable.ic_baseline_arrow_drop_up_24);
                    btnShow.setBackgroundResource(R.drawable.ic_baseline_arrow_drop_down_24);
                }
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
        conCari = v.findViewById(R.id.con_cari);
        editNamaSopir = v.findViewById(R.id.edit_nama_sopir);
        btnCari = v.findViewById(R.id.btn_cari);
        textView10 = v.findViewById(R.id.textView10);
        editTanggal = v.findViewById(R.id.edit_tanggal);
        btnShow = v.findViewById(R.id.btn_show);
        radioGroup = v.findViewById(R.id.radioGroup);
        rdSemua = v.findViewById(R.id.rd_semua);
        rdTnggal = v.findViewById(R.id.rd_tnggal);
        rdKemarin = v.findViewById(R.id.rd_kemarin);
        txtTgl = v.findViewById(R.id.txt_tgl);
        textView = v.findViewById(R.id.textView);
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
                txtTotol.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
            } else {
                textView.setVisibility(View.VISIBLE);
                txtTotol.setVisibility(View.VISIBLE);
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
    public void edit(int id, int id_sopir, int uang_jalan, int id_pemilik_mobil, String nama_sopir, String nama_pemilik_mobil) {
        Bundle args = new Bundle();
        args.putString("id", String.valueOf(id));
        args.putString("id_sopir", String.valueOf(id_sopir));
        args.putString("uang_jalan", String.valueOf(uang_jalan));
        args.putString("id_pemilik_mobil", String.valueOf(id_pemilik_mobil));
        args.putString("nama_sopir", nama_sopir);
        args.putString("nama_pemilik_mobil", nama_pemilik_mobil);
        args.putString("jenis", "edit");

        fragment_add_edit_uang_jalan newFragment = new fragment_add_edit_uang_jalan();
        newFragment.setArguments(args);
        newFragment.show(getActivity().getSupportFragmentManager(), "TAG");

    }

    @Override
    public void hapus(int id) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.cari_new, menu);
        MenuItem searchViewItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setQueryHint("Cari nama sopir...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                cari = query;
                rekapan.get_uang_jalan(tanggal, query, jenis, id_sopir_new);
                Log.i("sisisisisi", "onQueryTextSubmit: " + jenis + " " + tanggal + " " + query + " " + id_sopir_new);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void updateLabel() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        tanggal = sdf.format(myCalendar.getTime());
        editTanggal.setText(sdf.format(myCalendar.getTime()));
    }


    @Override
    public void data_sopir(String nama_sopir, String nama_pemilik_mobil, int pemilik_mobil_id, int mobil_id) {
        editNamaSopir.setText(nama_sopir);
        id_sopir_new = "" + mobil_id;
        nama_sopir_new = nama_sopir;
        // rekapan.get_uang_jalan(tanggal, cari, jenis, id_sopir_new);
        //  ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle(nama_sopir);
    }

    @Override
    public void sukses(String pesan) {

    }

    @Override
    public void gagal(String pesan) {

    }


}