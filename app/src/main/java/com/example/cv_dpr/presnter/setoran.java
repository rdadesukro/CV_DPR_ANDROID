package com.example.cv_dpr.presnter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.example.cv_dpr.model.rekapan.DataSetoranItem;
import com.example.cv_dpr.model.rekapan.Response_rekapan;
import com.example.cv_dpr.model.setoran.DataSetoranItem_setoran;
import com.example.cv_dpr.model.setoran.Response_setoran;
import com.example.cv_dpr.server.ApiRequest;
import com.example.cv_dpr.server.Retroserver_server_AUTH;
import com.example.cv_dpr.view.rekapan_view;
import com.example.cv_dpr.view.setoran_view;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

;

public class setoran {

    private Context ctx;
    private setoran_view countryView;
    private Retroserver_server_AUTH countryService;
    public setoran(setoran_view view, Context ctx) {
        this.countryView = view;
        this.ctx = ctx;

        if (this.countryService == null) {
            this.countryService = new Retroserver_server_AUTH();
        }
    }

    public void get_setoran(String mobil_id,String nama_sopir,String jenis,String tanngal) {
        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
        Log.i("isi_server", "isi_server: "+Retroserver_server_AUTH.getClient().baseUrl());
        Log.i("data_Setoran", "get_setoran: "+mobil_id+" "+nama_sopir + " "+jenis+ " "+tanngal);

        Call<Response_setoran> call = api.tampil_setoran_new(mobil_id,nama_sopir,jenis,tanngal);
        call.enqueue(new Callback<Response_setoran>() {
            @Override
            public void onResponse(Call<Response_setoran> call, Response<Response_setoran> response) {

                try {

                    if (response.isSuccessful()) {
                        Response_setoran data = response.body();
                        countryView.total_uang_jalan(data.getTotalUangJalan());
                        //Toast.makeText(ctx, ""+ response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Log.i("isi_data", "onResponse: "+data);
                        if (data != null && data.getDataSetoran() != null) {
                            List<DataSetoranItem_setoran> result = data.getDataSetoran();
                            countryView.setoran(result);
                        }
                    }
                } catch (Exception e) {
                    Log.e("onResponse", "There is an error" + e);
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Response_setoran> call, Throwable t) {
                t.printStackTrace();
                Log.i("cek_error", "onFailure: " + t);
                if (t instanceof IOException) {

                    Log.i("cek_error", "onFailure: " + t);
                } else {

                    Log.i("cek_error", "onFailure: " + t);
                }
            }
        });
    }

    }


