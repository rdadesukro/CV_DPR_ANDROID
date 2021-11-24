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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.cv_dpr.R;
import com.example.cv_dpr.presnter.mobil;
import com.example.cv_dpr.view.mobil_view;
import com.jpegkit.Jpeg;

import java.io.File;


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

    String jenis, nama_sopir, uang_jalan, nama_pemilik_mobil, id;
    private EditText editTglMuat;
    private EditText editBeratMuat;
    private EditText editBeratBongkar;
    private ImageView imgFotoDo;
    private Button button;


    public fragment_add_edit_setoran() {


    }

    private void initView(View V) {


        btnKeluar = V.findViewById(R.id.btn_keluar);
        btnSimpan = V.findViewById(R.id.button);
        editTglMuat = V.findViewById(R.id.edit_tgl_muat);
        editBeratMuat = V.findViewById(R.id.edit_berat_muat);
        editBeratBongkar = V.findViewById(R.id.edit_berat_bongkar);
        imgFotoDo = V.findViewById(R.id.img_foto_do);
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
//            nama_sopir = mArgs.getString("nama_sopir");
//            id = mArgs.getString("id");
//            uang_jalan = mArgs.getString("uang_jalan");
//            nama_pemilik_mobil = mArgs.getString("nama_pemilik_mobil");
//            id_mobil = Integer.parseInt(mArgs.getString("id_sopir"));
//            id_pemilik_mobil = Integer.parseInt(mArgs.getString("id_pemilik_mobil"));
//            editUangJalan.setText(uang_jalan);
//            editPemilikMobil.setText(nama_pemilik_mobil);
//            editSopir.setText(nama_sopir);
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
                mobil.simpan_uang_jalan(id_mobil,id_pemilik_mobil,editUangJalan.getText().toString().trim(),jenis,id);
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
