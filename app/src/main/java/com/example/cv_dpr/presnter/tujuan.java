package com.example.cv_dpr.presnter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.cv_dpr.model.trasnportir.DataTransportirItem;
import com.example.cv_dpr.model.trasnportir.Response_trasnportir;
import com.example.cv_dpr.model.tujuan.DataHargaItem_tujan;
import com.example.cv_dpr.model.tujuan.Response_tujuan;
import com.example.cv_dpr.server.ApiRequest;
import com.example.cv_dpr.server.Retroserver_server_AUTH;
import com.example.cv_dpr.view.trasnportir_view;
import com.example.cv_dpr.view.tujuan_view;
import com.example.spinner_dialog.SpinnerDialog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

;

public class tujuan {

    private Context ctx;
    private tujuan_view countryView;
    private Retroserver_server_AUTH countryService;
    SpinnerDialog spinnerDialog;
    String nama;
    int id_trasnportir;
    private List<String> nama_trasnportir = new ArrayList<String>();

    private List<Integer> transportir_id= new ArrayList<Integer>();
    public tujuan(tujuan_view view, Context ctx) {
        this.countryView = view;
        this.ctx = ctx;

        if (this.countryService == null) {
            this.countryService = new Retroserver_server_AUTH();
        }
    }

    public void get_tujuan() {

        ProgressDialog pDialog = new ProgressDialog(ctx);
        pDialog = new ProgressDialog(ctx);
        pDialog.setMessage("Mengambil Data...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.show();
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(true);
        ProgressDialog finalPDialog = pDialog;
        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
        Call<Response_tujuan> call = api.tampil_tujuan();
        call.enqueue(new Callback<Response_tujuan>() {
            @Override
            public void onResponse(Call<Response_tujuan> call, Response<Response_tujuan> response) {


                try {

                    if (response.isSuccessful()) {
                        finalPDialog.dismiss();
                        Response_tujuan data = response.body();
                        //Toast.makeText(ctx, ""+ response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Log.i("isi_data", "onResponse: "+data);
                        if (data != null && data.getDataHarga() != null) {
                            List<DataHargaItem_tujan> result = data.getDataHarga();
                            countryView.tujuan(result);
                        }
                    }
                } catch (Exception e) {
                    finalPDialog.dismiss();
                    Log.e("onResponse", "There is an error" + e);
                    e.printStackTrace();
                }
//                List<DataTransportirItem> result = data.getDataTransportir();
//
            }

            @Override
            public void onFailure(Call<Response_tujuan> call, Throwable t) {
                t.printStackTrace();
                Log.i("cek_eror_tujuan", "onFailure: "+t);
                if (t instanceof IOException) {
                   // pd.dismiss();
                    finalPDialog.dismiss();
                    //Toast.makeText(ErrorHandlingActivity.this, "this is an actual network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                    Toast.makeText(ctx, "Jaringan Anda Bermasalah", Toast.LENGTH_SHORT).show();

                }
                else {
                   // pd.dismiss();
                    finalPDialog.dismiss();
                    //  Toast.makeText(ErrorHandlingActivity.this, "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
                    // todo log to some central bug tracking service
                    Toast.makeText(ctx, "Jaringan Anda Bermasalah", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


    }


