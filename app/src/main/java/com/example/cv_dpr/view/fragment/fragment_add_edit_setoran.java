package com.example.cv_dpr.view.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.cv_dpr.R;
import com.example.cv_dpr.model.mobil.DataMobilItem;
import com.example.cv_dpr.model.pembyaran.DataKasbonItem;
import com.example.cv_dpr.model.pembyaran.DataPemilikMobilItem_mobil;
import com.example.cv_dpr.model.pembyaran.DataSetoranItem_pembayaran;
import com.example.cv_dpr.model.pembyaran.DataSopirItem_data;
import com.example.cv_dpr.presnter.mobil;
import com.example.cv_dpr.view.mobil_view;
import com.jpegkit.Jpeg;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_add_edit_setoran extends DialogFragment implements mobil_view {


    private static final String TAG = "fragment_camera";
    private ImageView btnKeluar;
    private EditText editSopir;
    private EditText editPemilikMobil;
    private EditText editUangJalan;
    private Button btnSimpan;

    com.example.cv_dpr.presnter.mobil mobil;
    int id_mobil, id_pemilik_mobil;
    int id;

    String tujuan,foto,jenis, nama_sopir, uang_jalan, nama_pemilik_mobil,berat_bongkar,berat_muat,tanngal_muat,tanggal_bongkar,harga,transportir_id;
    private EditText editTglMuat;
    private EditText editBeratMuat;
    private EditText editBeratBongkar;
    private ImageView imgFotoDo;
    private Button button;
    private EditText editTransportir;
    private EditText editTujuan;
    private EditText editHarga;
    private EditText editTglBongkar;
    DatePickerDialog.OnDateSetListener tgl_muat;
    DatePickerDialog.OnDateSetListener tgl_bongkar;
    final Calendar myCalendar = Calendar.getInstance();
    public fragment_add_edit_setoran() {


    }

    private void initView(View V) {


        btnKeluar = V.findViewById(R.id.btn_keluar);
        btnSimpan = V.findViewById(R.id.button);
        editTglMuat = V.findViewById(R.id.edit_tgl_muat);
        editBeratMuat = V.findViewById(R.id.edit_berat_muat);
        editBeratBongkar = V.findViewById(R.id.edit_berat_bongkar);
        imgFotoDo = V.findViewById(R.id.img_foto_do);
        editTransportir = V.findViewById(R.id.edit_transportir);
        editTujuan = V.findViewById(R.id.edit_tujuan);
        editHarga = V.findViewById(R.id.edit_harga);
        editTglBongkar = V.findViewById(R.id.edit_tgl_bongkar);
    }

    @Override
    public void data_sopir(String nama_sopir, String nama_pemilik_mobil, int pemilik_mobil_id, int mobil_id) {

        id_mobil = mobil_id;
        id_pemilik_mobil = pemilik_mobil_id;
        editSopir.setText(nama_sopir);
        editPemilikMobil.setText(nama_pemilik_mobil);

    }

    @Override
    public void sukses(String pesan) {
        Toast.makeText(getContext(), "" + pesan, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void gagal(String pesan) {
        //  Toasty.success(getActivity(), ""+pesan, Toast.LENGTH_SHORT, true).show();
        Toast.makeText(getContext(), "" + pesan, Toast.LENGTH_SHORT).show();
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


    public interface OnInputListener {
        void onSimpanClick(Jpeg data, File file);
    }

    public OnInputListener onInputListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.dialog_setoran, null);


        initView(view);
        mobil = new mobil(this, getActivity());


        Bundle mArgs = getArguments();
        jenis = mArgs.getString("jenis");

        if (jenis.equals("new")) {

        } else {


            foto = mArgs.getString("foto");
            id= Integer.parseInt(mArgs.getString("id"));
            tanngal_muat = mArgs.getString("tanngal_muat");
            tanggal_bongkar = mArgs.getString("tanggal_bongkar");
            berat_muat =  mArgs.getString("berat_muat");
            berat_bongkar =  mArgs.getString("berat_bongkar");
            transportir_id =  mArgs.getString("transportir_id");
            harga = mArgs.getString ("harga");
            tujuan =  mArgs.getString("tujuan");


            editTglMuat.setText(tanngal_muat);
            editTglBongkar.setText(tanggal_bongkar);
            editBeratMuat.setText(berat_muat);
            editBeratBongkar.setText(berat_bongkar);
            editTransportir.setText(transportir_id);
            editHarga.setText(harga);
            editTujuan.setText(tujuan);


        }

        editTglMuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), tgl_muat, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        editTglBongkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), tgl_bongkar, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().cancel();
            }
        });
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobil.edit_Setoran(id,
                        editTglMuat.getText().toString().trim(),
                        editTglBongkar.getText().toString().trim(),
                        editBeratMuat.getText().toString().trim(),
                        editBeratBongkar.getText().toString().trim(),
                        editTujuan.getText().toString().trim(),
                        editHarga.getText().toString().trim(),
                        "1");
            }
        });
        tgl_muat = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                tgl_muat();
            }

        };
        tgl_bongkar = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                tgl_bongkar();
            }

        };
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullscreenDialogTheme);
    }


    @SuppressLint("MissingSuperCall")
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            /* this line is main difference for fragment to fragment communication & fragment to activity communication
            fragment to fragment: onInputListener = (OnInputListener) getTargetFragment();
            fragment to activity: onInputListener = (OnInputListener) getActivity();
             */
            onInputListener = (OnInputListener) getTargetFragment();
            Log.i("isi_isi", "onAttach: " + onInputListener);
            Log.d(TAG, "onAttach: " + onInputListener);
        } catch (ClassCastException e) {
            Log.d(TAG, "onAttach: ClassCastException : " + e.getMessage());
        }
    }

    private void tgl_muat() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editTglMuat.setText(sdf.format(myCalendar.getTime()));
    }
    private void tgl_bongkar() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editTglBongkar.setText(sdf.format(myCalendar.getTime()));
    }
}
