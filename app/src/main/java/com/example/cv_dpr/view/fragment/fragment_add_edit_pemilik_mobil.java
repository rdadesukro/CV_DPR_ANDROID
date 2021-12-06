package com.example.cv_dpr.view.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.cv_dpr.R;
import com.example.cv_dpr.model.pemilik_mobil.DataPemilikMobilItem;
import com.example.cv_dpr.presnter.pemilik_mobil;
import com.example.cv_dpr.view.pemilik_mobil_view;
import com.google.android.material.textfield.TextInputLayout;
import com.jpegkit.Jpeg;

import java.io.File;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_add_edit_pemilik_mobil extends DialogFragment implements pemilik_mobil_view {


    private static final String TAG = "fragment_camera";
    private ImageView btnKeluar;
    private EditText editSopir;
    private EditText editPemilikMobil;
    private EditText editUangJalan;
    private Button btnSimpan;

    com.example.cv_dpr.presnter.mobil mobil;
    int id_mobil, id_pemilik_mobil;

    String tujuan, foto, jenis, nama_sopir, uang_jalan, nama_pemilik_mobil, id, berat_bongkar, berat_muat, tanngal_muat, tanggal_bongkar, harga, transportir_id;
    private EditText editTglMuat;
    private EditText editBeratMuat;
    private EditText editBeratBongkar;
    private ImageView imgFotoDo;
    private Button button;
    private EditText editTransportir;
    private EditText editTujuan;
    private EditText editHarga;
    private EditText editTglBongkar;
    private ImageView imageView2;
    private TextView textView2;
    private TextInputLayout xxx;
    private EditText editNama;
    private TextInputLayout newfsdsdff;
    private EditText editJumlah;
    private TextInputLayout vvvv;
    String nama, jumlah_unit;

    String id_pemilik;
    com.example.cv_dpr.presnter.pemilik_mobil pemilik_mobil;


    public fragment_add_edit_pemilik_mobil() {


    }

    private void initView(View V) {


        imageView2 = V.findViewById(R.id.imageView2);
        textView2 = V.findViewById(R.id.textView2);
        xxx = V.findViewById(R.id.xxx);

        editNama = V.findViewById(R.id.edit_nama);
        btnKeluar = V.findViewById(R.id.btn_keluar);
        btnSimpan = V.findViewById(R.id.button);
        newfsdsdff = V.findViewById(R.id.newfsdsdff);
        editJumlah = V.findViewById(R.id.edit_jumlah);
        vvvv = V.findViewById(R.id.vvvv);


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
    public void pemilik_mobil(List<DataPemilikMobilItem> pemilik_mobil) {

    }


    public interface OnInputListener {
        void onSimpanClick(Jpeg data, File file);
    }

    public OnInputListener onInputListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.dialog_pemilik_mobil, null);


        initView(view);
        pemilik_mobil = new pemilik_mobil(this, getActivity());

//
        Bundle mArgs = getArguments();
        jenis = mArgs.getString("jenis");

        if (jenis.equals("new")) {

        } else {


            id_pemilik = mArgs.getString("id");
            nama = mArgs.getString("nama");
            jumlah_unit = mArgs.getString("jumlah_unit");


            editNama.setText(nama);
            editJumlah.setText(jumlah_unit);

        }


//
//        editSopir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mobil.get_mobil();
//            }
//        });
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().cancel();
            }
        });
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pemilik_mobil.simpan_pemilik_mobil(id_pemilik, editNama.getText().toString().trim(), editJumlah.getText().toString().trim(), jenis);

            }
        });
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


}
