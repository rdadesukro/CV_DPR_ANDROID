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

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.cv_dpr.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.jpegkit.Jpeg;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_filter extends DialogFragment {


    private static final String TAG = "fragment_camera";
    private Button btnCari;
    private EditText editNamaSopir;
    private MaterialButtonToggleGroup grupWaktu;
    private MaterialButton btnTangal;
    private MaterialButton btnToday;
    private MaterialButton btnKemarin;
    private ImageView btnClose;


    public fragment_filter() {


    }

    private void initView(View V) {


//        btnCari = V.findViewById(R.id.btn_cari);
//        editNamaSopir = V.findViewById(R.id.edit_nama_sopir);
//        grupWaktu = V.findViewById(R.id.grup_waktu);
//        btnTangal = V.findViewById(R.id.btn_tangal);
//        btnToday = V.findViewById(R.id.btn_today);
//        btnKemarin = V.findViewById(R.id.btn_kemarin);
//        btnClose =  V.findViewById(R.id.btn_close);
    }


    public interface OnInputListener {
        void onSimpanClick(Jpeg data, File file);
    }

    public OnInputListener onInputListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.dialog_filter_data, null);


        initView(view);


        editNamaSopir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getDialog().cancel();
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().cancel();
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
