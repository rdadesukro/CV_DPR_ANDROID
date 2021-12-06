package com.example.cv_dpr.view.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.example.cv_dpr.R;
import com.example.cv_dpr.model.mobil.DataMobilItem;
import com.example.cv_dpr.model.pembyaran.DataKasbonItem;
import com.example.cv_dpr.model.pembyaran.DataPemilikMobilItem_mobil;
import com.example.cv_dpr.model.pembyaran.DataSetoranItem_pembayaran;
import com.example.cv_dpr.model.pembyaran.DataSopirItem_data;
import com.example.cv_dpr.presnter.mobil;
import com.example.cv_dpr.view.mobil_view;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class menu_pembayaran extends AppCompatActivity implements mobil_view {

    private CardView cardView4;
    private ConstraintLayout conCari;
    private TextInputLayout txtTglMulai;
    private EditText editTanggalMuali;
    private Button btnBayar;
    private RadioGroup radioJenis;
    private RadioButton rdPemilikMobil;
    private RadioButton rdSopir;
    private TextView textView12;
    private TextView textView11;
    private RadioGroup radioGroup;
    private RadioButton rdSemua;
    private RadioButton rdTnggal;
    private TextInputLayout txtUser;
    private EditText editNamaSopir;
    private Button btnrekap;
    private TextInputLayout txtTgl;
    private EditText editTanggalAkhir;
    private TextView textView10;
    private ImageView btnShow;
    String waktu;
    com.example.cv_dpr.presnter.mobil mobil;
    String jenis = "pemilik mobil";
    String id;
    final Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener tgl_mualai;
    DatePickerDialog.OnDateSetListener tgl_akhir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pembayaran);
        initView();
        mobil = new mobil(this,menu_pembayaran.this);
        btnShow.setBackgroundResource(R.drawable.ic_baseline_arrow_drop_down_24);
        tgl_mualai = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        tgl_akhir = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel1();
            }

        };

    }

    private void initView() {
        cardView4 = findViewById(R.id.cardView4);
        conCari = findViewById(R.id.con_cari);
        txtTglMulai = findViewById(R.id.txt_tgl_mulai);
        editTanggalMuali = findViewById(R.id.edit_tanggal_muali);
        btnBayar = findViewById(R.id.btn_bayar);
        radioJenis = findViewById(R.id.radio_jenis);
        rdPemilikMobil = findViewById(R.id.rd_pemilik_mobil);
        rdSopir = findViewById(R.id.rd_sopir);
        textView12 = findViewById(R.id.textView12);
        textView11 = findViewById(R.id.textView11);
        radioGroup = findViewById(R.id.radioGroup);
        rdSemua = findViewById(R.id.rd_semua);
        rdTnggal = findViewById(R.id.rd_tnggal);
        txtUser = findViewById(R.id.txt_user);
        editNamaSopir = findViewById(R.id.edit_nama_sopir);
        btnrekap = findViewById(R.id.btn_cek_rekap);
        txtTgl = findViewById(R.id.txt_tgl);
        editTanggalAkhir = findViewById(R.id.edit_tanggal_akhir);
        textView10 = findViewById(R.id.textView10);
        btnShow = findViewById(R.id.btn_show);

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
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rd_semua:

                        waktu="semua";
                        txtTgl.setVisibility(View.GONE);
                        txtTglMulai.setVisibility(View.GONE);
                        break;
                    case R.id.rd_tnggal:
                        waktu = "tanggal";
                        txtTgl.setVisibility(View.VISIBLE);
                        txtTglMulai.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
        radioJenis.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rd_pemilik_mobil:
                        jenis = "pemilik mobil";
                        txtUser.setHint("Nama Pemilik Mobil");
                        break;
                    case R.id.rd_sopir:
                        jenis = "sopir";
                        txtUser.setHint("Nama Sopir");
                        break;
                }
            }
        });

        editTanggalMuali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(menu_pembayaran.this, tgl_mualai, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        editTanggalAkhir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(menu_pembayaran.this, tgl_akhir, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        editNamaSopir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jenis.equals("sopir")){
                    mobil.get_mobil();
                }else {
                    mobil.get_pemilik_mobil();
                }

            }
        });
        
        btnrekap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("data_kirim", "onClick: "+id+" "+jenis+" "+editTanggalMuali.getText().toString().trim()+" "+editTanggalAkhir.getText().toString().trim());
                mobil.get_rekapan(id,jenis,waktu,editTanggalMuali.getText().toString().trim(),editTanggalAkhir.getText().toString().trim());

            }
        });


    }

    @Override
    public void data_sopir(String nama_sopir, String nama_pemilik_mobil, int pemilik_mobil_id, int mobil_id) {
        editNamaSopir.setText(nama_sopir);
        if (jenis.equals("sopir")){
            id= String.valueOf(mobil_id);

        }else {
            id= String.valueOf(pemilik_mobil_id);
        }

    }

    @Override
    public void sukses(String pesan) {
        Toast.makeText(this, ""+pesan, Toast.LENGTH_SHORT).show();
        Intent ii=new Intent(this, menu_data_pembayaran.class);
        ii.putExtra("id", id);
        ii.putExtra("jenis", jenis);
        ii.putExtra("waktu", waktu);
        ii.putExtra("from", editTanggalMuali.getText().toString().trim());
        ii.putExtra("to", editTanggalAkhir.getText().toString().trim());
        startActivity(ii);

    }

    @Override
    public void gagal(String pesan) {
        Toast.makeText(this, ""+pesan, Toast.LENGTH_SHORT).show();
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

    private void updateLabel() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editTanggalMuali.setText(sdf.format(myCalendar.getTime()));
    }
    private void updateLabel1() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editTanggalAkhir.setText(sdf.format(myCalendar.getTime()));
    }
    public void get_laporan_selesai() {


    }

}