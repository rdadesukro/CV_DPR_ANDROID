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
import com.example.cv_dpr.model.mobil.DataMobilItem;
import com.example.cv_dpr.model.pembyaran.DataKasbonItem;
import com.example.cv_dpr.model.pembyaran.DataPemilikMobilItem_mobil;
import com.example.cv_dpr.model.pembyaran.DataSetoranItem_pembayaran;
import com.example.cv_dpr.model.pembyaran.DataSopirItem_data;
import com.example.cv_dpr.model.pemilik_mobil.DataPemilikMobilItem;
import com.example.cv_dpr.presnter.mobil;
import com.example.cv_dpr.presnter.pemilik_mobil;
import com.example.cv_dpr.view.mobil_view;
import com.example.cv_dpr.view.pemilik_mobil_view;
import com.google.android.material.textfield.TextInputLayout;
import com.jpegkit.Jpeg;

import java.io.File;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_add_edit_sopir_mobil extends DialogFragment implements pemilik_mobil_view, mobil_view {


    private static final String TAG = "fragment_camera";

    com.example.cv_dpr.presnter.mobil mobil;
    int id_mobil, id_pemilik_mobil;
    int id;

    String jenis, nama_sopir, pemilik_mobil_id, jenis_mobil, nopol;

    String nama, jumlah_unit;
    String nama_pemilik;

    String id_pemilik;
    com.example.cv_dpr.presnter.pemilik_mobil pemilik_mobil;
    private ImageView btnKeluar;
    private TextView textView2;
    private TextInputLayout aa;
    private EditText editNama;
    private TextInputLayout bbb;
    private EditText editNamaSopir;
    private TextInputLayout xxx;
    private EditText editNopol;
    private TextInputLayout newfsdsdff;
    private EditText editJenis;
    private TextInputLayout vvvv;
    private Button button;



    public fragment_add_edit_sopir_mobil() {


    }


    @Override
    public void data_sopir(String nama_sopir, String nama_pemilik_mobil, int pemilik_mobil_id, int mobil_id) {

        editNama.setText(nama_pemilik_mobil);
        id_pemilik_mobil = pemilik_mobil_id;
        Toast.makeText(getActivity(), ""+id_pemilik_mobil, Toast.LENGTH_SHORT).show();

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

    @Override
    public void pemilik_mobil(List<DataPemilikMobilItem> pemilik_mobil) {

    }

    private void initView(View V) {

        btnKeluar = V.findViewById(R.id.btn_keluar);
        textView2 =  V.findViewById(R.id.textView2);
        aa =  V.findViewById(R.id.aa);
        editNama =  V.findViewById(R.id.edit_nama);
        bbb =  V.findViewById(R.id.bbb);
        editNamaSopir =  V.findViewById(R.id.edit_nama_sopir);
        xxx =  V.findViewById(R.id.xxx);
        editNopol =  V.findViewById(R.id.edit_nopol);
        newfsdsdff =  V.findViewById(R.id.newfsdsdff);
        editJenis =  V.findViewById(R.id.edit_jenis);
        vvvv =  V.findViewById(R.id.vvvv);
        button =  V.findViewById(R.id.button);
    }


    public interface OnInputListener {
        void onSimpanClick(Jpeg data, File file);
    }

    public OnInputListener onInputListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.dialog_sopir, null);
        initView(view);

        pemilik_mobil = new pemilik_mobil(this, getActivity());
        mobil = new mobil(this, getActivity());

//
        Bundle mArgs = getArguments();
        jenis = mArgs.getString("jenis");

        if (jenis.equals("new")) {

        } else {


            id_pemilik_mobil = Integer.parseInt(mArgs.getString("pemilik_mobil_id"));
            nama_sopir = mArgs.getString("nama_sopir");
            nama_pemilik = mArgs.getString("nama_pemilik");
            jenis_mobil = mArgs.getString("jenis_mobil");
            id = Integer.parseInt(mArgs.getString("id"));
            nopol = mArgs.getString("nopol");


            editNamaSopir.setText(nama_sopir);
            editNama.setText(nama_pemilik);
            editJenis.setText(jenis);
            editNopol.setText(nopol);



        }


//
        editNama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobil.get_pemilik_mobil();
            }
        });
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().cancel();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobil.simpan_sopir(id,
                        editNamaSopir.getText().toString().trim(),
                        id_pemilik_mobil,
                        editJenis.getText().toString().trim(),
                        editNopol.getText().toString().trim(),jenis);


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
