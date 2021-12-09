package com.example.cv_dpr.presnter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.cv_dpr.model.trasnportir.DataTransportirItem;
import com.example.cv_dpr.model.trasnportir.Response_trasnportir;
import com.example.cv_dpr.server.ApiRequest;
import com.example.cv_dpr.server.Retroserver_server_AUTH;
import com.example.cv_dpr.view.trasnportir_view;
import com.example.spinner_dialog.SpinnerDialog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

;

public class trasnportir {

    private Context ctx;
    private trasnportir_view countryView;
    private Retroserver_server_AUTH countryService;
    SpinnerDialog spinnerDialog;
    String nama;
    int id_trasnportir;
    private List<String> nama_trasnportir = new ArrayList<String>();

    private List<Integer> transportir_id= new ArrayList<Integer>();
    public trasnportir(trasnportir_view view, Context ctx) {
        this.countryView = view;
        this.ctx = ctx;

        if (this.countryService == null) {
            this.countryService = new Retroserver_server_AUTH();
        }
    }

    public void get_trasnporir() {

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
        Call<Response_trasnportir> call = api.tampil_transportir();
        call.enqueue(new Callback<Response_trasnportir>() {
            @Override
            public void onResponse(Call<Response_trasnportir> call, Response<Response_trasnportir> response) {


                try {

                    if (response.isSuccessful()) {
                        finalPDialog.dismiss();
                        Response_trasnportir data = response.body();
                        //Toast.makeText(ctx, ""+ response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Log.i("isi_data", "onResponse: "+data);
                        if (data != null && data.getDataTransportir() != null) {
                            List<DataTransportirItem> result = data.getDataTransportir();
                            countryView.transportir(result);
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
            public void onFailure(Call<Response_trasnportir> call, Throwable t) {
                t.printStackTrace();
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


