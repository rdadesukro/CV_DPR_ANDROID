package com.example.cv_dpr.presnter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.cv_dpr.model.pencairan.DataSeotoranItem_cair;
import com.example.cv_dpr.model.pencairan.Response_cair;
import com.example.cv_dpr.model.trasnportir.DataTransportirItem;
import com.example.cv_dpr.model.trasnportir.Response_trasnportir;
import com.example.cv_dpr.server.ApiRequest;
import com.example.cv_dpr.server.Retroserver_server_AUTH;
import com.example.cv_dpr.view.cair_view;
import com.example.spinner_dialog.SpinnerDialog;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

;

public class cair {

    private Context ctx;
    private cair_view countryView;
    private Retroserver_server_AUTH countryService;
    SpinnerDialog spinnerDialog;
    public cair(cair_view view, Context ctx) {
        this.countryView = view;
        this.ctx = ctx;

        if (this.countryService == null) {
            this.countryService = new Retroserver_server_AUTH();
        }
    }

    public void get_transportir() {

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

   
    public void get_pencairan(int jenis) {
        ProgressDialog pDialog = new ProgressDialog(ctx);
        pDialog = new ProgressDialog(ctx);
        pDialog.setTitle("Mohon Tunggu!!!");
        pDialog.setMessage("Mencari Data...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.show();
        ProgressDialog finalPDialog = pDialog;
        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
        Call<Response_cair> sendbio;

       
        sendbio = api.tampil_pencairan(jenis);
     

        ProgressDialog finalPDialog1 = pDialog;
        sendbio.enqueue(new Callback<Response_cair>() {
            @Override
            public void onResponse(Call<Response_cair> call, Response<Response_cair> response) {

                try {

                    if (response.isSuccessful()) {
                        finalPDialog.dismiss();
                        Response_cair data = response.body();
                        countryView.data(data.getHasil(), String.valueOf(data.getTotalDo()));
                        //Toast.makeText(ctx, ""+ response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Log.i("isi_data", "onResponse: "+data);
                      if (data.getDataSeotoran().size() == 0){

                          countryView.gagal("data tidak ada");

                      }else {
                          countryView.sukses("data tidak ada");
                          if (data != null && data.getDataSeotoran() != null) {
                              List<DataSeotoranItem_cair> result = data.getDataSeotoran();
                              countryView.data_cair(result);
                          }
                      }

                    }
                } catch (Exception e) {
                    finalPDialog.dismiss();
                    Log.e("onResponse", "There is an error" + e);
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<Response_cair> call, Throwable t) {
                Log.e("cek_eror_login", "onFailure: "+t);

                Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
            }
        });

    }
   

    }


