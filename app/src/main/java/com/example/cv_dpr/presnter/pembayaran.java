package com.example.cv_dpr.presnter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.cv_dpr.model.buat_pdf.Response_pdf;
import com.example.cv_dpr.model.trasnportir.DataTransportirItem;
import com.example.cv_dpr.model.trasnportir.Response_trasnportir;
import com.example.cv_dpr.server.ApiRequest;
import com.example.cv_dpr.server.Retroserver_server_AUTH;
import com.example.cv_dpr.view.pembayaran_view;
import com.example.cv_dpr.view.trasnportir_view;
import com.example.spinner_dialog.SpinnerDialog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

;

public class pembayaran {

    private Context ctx;
    private pembayaran_view countryView;
    private Retroserver_server_AUTH countryService;
    SpinnerDialog spinnerDialog;
    String nama;
    int id_trasnportir;
    private List<String> nama_trasnportir = new ArrayList<String>();

    private List<Integer> transportir_id= new ArrayList<Integer>();
    public pembayaran(pembayaran_view view, Context ctx) {
        this.countryView = view;
        this.ctx = ctx;

        if (this.countryService == null) {
            this.countryService = new Retroserver_server_AUTH();
        }
    }

    public void get_pembayaran_pdf(String id,String jenis,String waktu,String from,String to) {
        ProgressDialog pDialog = new ProgressDialog(ctx);
        pDialog = new ProgressDialog(ctx);
        pDialog.setTitle("Mohon Tunggu!!!");
        pDialog.setMessage("Mencari Data...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.show();
        ProgressDialog finalPDialog = pDialog;
        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
        Call<Response_pdf> sendbio;


        sendbio = api.get_pembayaran_pdf(id,
                jenis,
                waktu,
                from,
                to);


        ProgressDialog finalPDialog1 = pDialog;
        sendbio.enqueue(new Callback<Response_pdf>() {
            @Override
            public void onResponse(Call<Response_pdf> call, Response<Response_pdf> response) {

                try {

                    if (response.isSuccessful()) {
                        finalPDialog.dismiss();
                        Response_pdf data = response.body();
                        String pesan = data.getMessage();
                        String lokasi= data.getLokasi();
                        if (data.isKode()){
                            countryView.sukses(pesan,lokasi);
                        }else {
                            countryView.gagal(pesan);
                        }


                    }
                } catch (Exception e) {
                    Log.i("cek_", "onResponse: "+e);
                    finalPDialog.dismiss();
                    Log.e("onResponse", "There is an error" + e);
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<Response_pdf> call, Throwable t) {
                Log.e("cek_eror_login", "onFailure: "+t);

                Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
            }
        });

    }

    }


