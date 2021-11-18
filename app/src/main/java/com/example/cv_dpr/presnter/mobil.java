package com.example.cv_dpr.presnter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cv_dpr.model.rekapan.DataSetoranItem;
import com.example.cv_dpr.model.rekapan.Response_rekapan;
import com.example.cv_dpr.model.rekapan.mobil.DataMobilItem;
import com.example.cv_dpr.model.rekapan.mobil.Response_mobil;
import com.example.cv_dpr.server.ApiRequest;
import com.example.cv_dpr.server.Retroserver_server_AUTH;
import com.example.cv_dpr.view.mobil_view;
import com.example.cv_dpr.view.rekapan_view;
import com.example.spinner_dialog.OnSpinerItemClick;
import com.example.spinner_dialog.SpinnerDialog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

;

public class mobil {

    private Context ctx;
    private mobil_view countryView;
    private Retroserver_server_AUTH countryService;
    SpinnerDialog spinnerDialog;
    String nama_sopir,nama_pemilik_mobil;
    int id_pemilik_mobil;
    private List<String> results = new ArrayList<String>();
    private List<String> results1 = new ArrayList<String>();
    private List<String> results2 = new ArrayList<String>();
    public mobil(mobil_view view, Context ctx) {
        this.countryView = view;
        this.ctx = ctx;

        if (this.countryService == null) {
            this.countryService = new Retroserver_server_AUTH();
        }
    }

    public void get_mobil(ProgressDialog pd) {
        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
        Call<Response_mobil> call = api.get_mobil();
        call.enqueue(new Callback<Response_mobil>() {
            @Override
            public void onResponse(Call<Response_mobil> call, Response<Response_mobil> response) {

                results = new ArrayList();

                Response_mobil data = response.body();
                List<DataMobilItem> result = data.getDataMobil();

                for (int i = 0; i < result.size(); i++) {
                    id_pemilik_mobil = result.get(i).getPemilikMobilId();
                    nama_sopir = result.get(i).getNamaSopir();
                    nama_pemilik_mobil = result.get(i).getPemilikMobil().get(i).getNama();
                    results.add(result.get(i).getNamaSopir());
                    results1.add(result.get(i).getNamaSopir());
                    results.add(result.get(i).getNamaSopir());

                }
               // pd.dismiss();
                spinnerDialog = new SpinnerDialog((AppCompatActivity) ctx, (ArrayList<String>) results, "Pilih Sopir Mobil");
                spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
                    @Override
                    public void onClick(String item, int position) {

                        Toast.makeText(ctx, ""+results.get(position), Toast.LENGTH_SHORT).show();
                        countryView.data_sopir(nama_sopir,nama_pemilik_mobil, String.valueOf(id_pemilik_mobil));




                    }
                });

                if (spinnerDialog == null) {
                    Toast.makeText(ctx, "jaringan bermasalah...", Toast.LENGTH_SHORT);
                } else {
                    spinnerDialog.showSpinerDialog("muncul");
                   // pd.dismiss();
                }
            }

            @Override
            public void onFailure(Call<Response_mobil> call, Throwable t) {
                t.printStackTrace();
                if (t instanceof IOException) {
                   // pd.dismiss();
                    //Toast.makeText(ErrorHandlingActivity.this, "this is an actual network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                    Toast.makeText(ctx, "Jaringan Anda Bermasalah", Toast.LENGTH_SHORT).show();

                }
                else {
                   // pd.dismiss();
                    //  Toast.makeText(ErrorHandlingActivity.this, "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
                    // todo log to some central bug tracking service
                    Toast.makeText(ctx, "Jaringan Anda Bermasalah", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    }


