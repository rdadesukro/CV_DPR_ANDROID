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
import android.view.Window;
import android.view.WindowManager;
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
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.cv_dpr.R;
import com.example.cv_dpr.adapter.adapter_setoran;
import com.example.cv_dpr.model.mobil.DataMobilItem;
import com.example.cv_dpr.model.pembyaran.DataKasbonItem;
import com.example.cv_dpr.model.pembyaran.DataPemilikMobilItem_mobil;
import com.example.cv_dpr.model.pembyaran.DataSetoranItem_pembayaran;
import com.example.cv_dpr.model.pembyaran.DataSopirItem_data;
import com.example.cv_dpr.model.rekapan.DataSetoranItem;
import com.example.cv_dpr.presnter.mobil;
import com.example.cv_dpr.presnter.rekapan;
import com.example.cv_dpr.view.mobil_view;
import com.example.cv_dpr.view.rekapan_view;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;


public class fragment_setoran extends Fragment implements mobil_view,rekapan_view, adapter_setoran.OnImageClickListener {


    private SwipeRefreshLayout swifeRefresh;
    private RecyclerView rvAku;
    private ImageView imgData;
    private TextView txtData;
    private ProgressBar progressBar4;

    com.example.cv_dpr.presnter.rekapan rekapan;
    private adapter_setoran adapter_setoran;
    private TextView txtTotol;
    private FloatingActionButton btnAdd2;
    String cari="";
    Button btn_cari;

    BottomSheetDialog dialog;
    MaterialButtonToggleGroup btn_grup;
    String mobil_id;
    String jenis="semua";
    DatePickerDialog.OnDateSetListener tg;
    String tanggal;
    RadioGroup radioGroup;
    RadioButton rd_semua,rd_tgl,rd_kemari;
    EditText edit_nama;
    EditText edit_tgl;
    final Calendar myCalendar = Calendar.getInstance();
    private TextInputLayout txtTgl;
    com.example.cv_dpr.presnter.mobil mobil;
    String id_sopir_new;

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
        //rekapan.get_setoran(mobil_id,cari,jenis,tanggal);
        rekapan.get_uang_jalan(tanggal, cari, jenis, id_sopir_new);
        mobil = new mobil(this,getActivity());

        swifeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                rekapan.get_uang_jalan(tanggal, cari, jenis, id_sopir_new);

            }
        });


//        rvAku.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                Log.i("isi_rvku", "onScrolled: " + dx + " " + dy);
//                if (dy > 0 && btnAdd2.getVisibility() == View.VISIBLE) {
//                    btnAdd2.hide();
//                } else if (dy < 0 && btnAdd2.getVisibility() != View.VISIBLE) {
//                    btnAdd2.show();
//                }
//            }
//        });



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
                progressBar4.setVisibility(View.GONE);
                txtData.setVisibility(View.VISIBLE);
                imgData.setVisibility(View.VISIBLE);
                //  cardEvent.setVisibility(View.GONE);
            } else {
                txtData.setVisibility(View.GONE);
                imgData.setVisibility(View.GONE);
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
    public void edit(int id, String foto,String tanngal_muat,String tanggal_bongkar,String berat_muat,String berat_bongkar,int transportir_id,int harga,String tujuan) {
        Bundle args = new Bundle();
        args.putString("id", String.valueOf(id));
        args.putString("foto", foto);
        args.putString("tanngal_muat", tanngal_muat);
        args.putString("tanggal_bongkar", tanggal_bongkar);
        args.putString("berat_muat",berat_muat);
        args.putString("berat_bongkar",berat_bongkar);
        args.putString("transportir_id", String.valueOf(transportir_id));
        args.putString("harga", String.valueOf(harga));
        args.putString("tujuan", tujuan);
        args.putString("jenis","edit");
        fragment_add_edit_setoran newFragment = new fragment_add_edit_setoran();
        newFragment.setArguments(args);
        newFragment.show(getActivity().getSupportFragmentManager(), "TAG");

    }

    @Override
    public void hapus(int id) {

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.cari, menu);
        MenuItem refres = menu.findItem(R.id.fiter);
        MenuItem searchViewItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setQueryHint("Cari nama sopir...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                cari=query;
                rekapan.get_setoran(mobil_id,cari,jenis,tanggal);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        refres.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                dialog = new BottomSheetDialog(getActivity());
                dialog.setTitle("Login");
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_filter_data);
                dialog.setCancelable(true);

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                dialog.getWindow().setAttributes(lp);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                dialog.getWindow().setDimAmount(0.5f);
                lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

                edit_nama = dialog.findViewById(R.id.edit_nama_sopir);
                edit_tgl = dialog.findViewById(R.id.edit_tanggal);
                radioGroup = dialog.findViewById(R.id.radioGroup);
                rd_kemari = dialog.findViewById(R.id.rd_kemarin);
                rd_semua = dialog.findViewById(R.id.rd_semua);
                rd_tgl = dialog.findViewById(R.id.rd_tnggal);
                txtTgl = dialog.findViewById(R.id.txt_tgl);
                btn_cari =dialog.findViewById(R.id.btn_cari);


                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date date = new Date(System.currentTimeMillis());
                tanggal = formatter.format(date);
                tg = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        Log.i("isi_tanggal", "onCreateView: " + tanggal);
                        updateLabel();
                    }

                };
                edit_nama.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mobil.get_mobil();


                    }
                });
                edit_tgl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
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
                btn_cari.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (jenis.equals("tanggal")) {
                            if (edit_nama.getText().toString().trim().equals("")) {
                                Toasty.error(getActivity(), "Nama Sopir Harus Di Isi", Toast.LENGTH_SHORT, true).show();
                            } else if (edit_tgl.getText().toString().trim().equals("")) {
                                Toasty.error(getActivity(), "Tanggal Harus Di Isi", Toast.LENGTH_SHORT, true).show();
                            } else {
                                rekapan.get_uang_jalan(tanggal, cari, jenis, id_sopir_new);
                            }
                        } else {
                            if (edit_nama.getText().toString().trim().equals("")) {
                                Toasty.error(getActivity(), "Nama Sopir Harus Di Isi", Toast.LENGTH_SHORT, true).show();
                            } else {
                                rekapan.get_uang_jalan(tanggal, cari, jenis, id_sopir_new);
                            }
                        }
                    }
                });



                dialog.show();
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
    private void updateLabel() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
//        ed = sdf.format(myCalendar.getTime());
        tanggal = sdf.format(myCalendar.getTime());
        edit_tgl.setText( sdf.format(myCalendar.getTime()));
    }

    @Override
    public void data_sopir(String nama_sopir, String nama_pemilik_mobil, int pemilik_mobil_id, int mobil_id) {

        //Toast.makeText(getContext(), ""+nama_sopir, Toast.LENGTH_SHORT).show();
        edit_nama.setText(nama_sopir);
        id_sopir_new= String.valueOf(mobil_id);

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

    }

    @Override
    public void data_pemilik_mobil(List<DataPemilikMobilItem_mobil> pemilik_mobil) {

    }
}