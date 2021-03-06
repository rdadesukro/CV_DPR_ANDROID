package com.example.cv_dpr.presnter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;


import com.example.cv_dpr.model.rekapan.DataSetoranItem;
import com.example.cv_dpr.model.rekapan.Response_rekapan;
import com.example.cv_dpr.server.ApiRequest;
import com.example.cv_dpr.server.Retroserver_server_AUTH;
import com.example.cv_dpr.view.rekapan_view;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

;

public class rekapan {

    private Context ctx;
    private rekapan_view countryView;
    private Retroserver_server_AUTH countryService;
    public rekapan(rekapan_view view, Context ctx) {
        this.countryView = view;
        this.ctx = ctx;

        if (this.countryService == null) {
            this.countryService = new Retroserver_server_AUTH();
        }
    }

    public void get_uang_jalan(String tanggal,String nama_sopir,String jenis,String mobil_id) {

        ProgressDialog pDialog = new ProgressDialog(ctx);
        pDialog = new ProgressDialog(ctx);
        pDialog.setMessage("Mencari Data...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.show();
        ProgressDialog finalPDialog = pDialog;
        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
        Log.i("isi_server", "isi_server: "+Retroserver_server_AUTH.getClient().baseUrl());

        Call<Response_rekapan> call = api.get_uang_jalan(tanggal,nama_sopir,jenis,mobil_id);
        call.enqueue(new Callback<Response_rekapan>() {
            @Override
            public void onResponse(Call<Response_rekapan> call, Response<Response_rekapan> response) {

                try {

                    if (response.isSuccessful()) {
                        finalPDialog.dismiss();
                        Response_rekapan data = response.body();
                        countryView.total_uang_jalan(data.getTotalUangJalan());
                        //Toast.makeText(ctx, ""+ response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Log.i("isi_data", "onResponse: "+data);
                        if (data != null && data.getDataSetoran() != null) {
                            List<DataSetoranItem> result = data.getDataSetoran();
                            countryView.rekapan(result);
                        }
                    }
                } catch (Exception e) {
                    finalPDialog.dismiss();
                    Log.e("onResponse", "There is an error" + e);
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Response_rekapan> call, Throwable t) {
                t.printStackTrace();
                finalPDialog.dismiss();
                Log.i("cek_error", "onFailure: " + t);
                if (t instanceof IOException) {

                    Log.i("cek_error", "onFailure: " + t);
                } else {

                    Log.i("cek_error", "onFailure: " + t);
                }
            }
        });
    }

//    public void get_rekapan(String id,String jenis,String waktu,String from,String to) {
//
//        ProgressDialog pDialog = new ProgressDialog(ctx);
//        pDialog = new ProgressDialog(ctx);
//        pDialog.setMessage("Mencari Data...");
//        pDialog.setCancelable(false);
//        pDialog.setCanceledOnTouchOutside(false);
//        pDialog.show();
//        ProgressDialog finalPDialog = pDialog;
//        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
//        Log.i("isi_server", "isi_server: "+Retroserver_server_AUTH.getClient().baseUrl());
//
//        Call<Response> call = api.get_rekapan(id,jenis,waktu,from,to);
//        call.enqueue(new Callback<Response>() {
//            @Override
//            public void onResponse(Call<Response> call, Response<Response> response) {
//
//                try {
//
//                    if (response.isSuccessful()) {
//                        finalPDialog.dismiss();
//                        Log.i("isi_respon", "onResponse: "+response.code());
//
//                    }
//                } catch (Exception e) {
//                    finalPDialog.dismiss();
//                    Log.e("onResponse", "There is an error" + e);
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<Response> call, Throwable t) {
//                t.printStackTrace();
//                finalPDialog.dismiss();
//                Log.i("cek_error", "onFailure: " + t);
//                if (t instanceof IOException) {
//
//                    Log.i("cek_error", "onFailure: " + t);
//                } else {
//
//                    Log.i("cek_error", "onFailure: " + t);
//                }
//            }
//        });
//    }
    public void get_setoran(String mobil_id,String nama_sopir,String jenis,String tanngal) {
        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
        Log.i("isi_server", "isi_server: "+Retroserver_server_AUTH.getClient().baseUrl());

        Call<Response_rekapan> call = api.tampil_setoran(mobil_id,nama_sopir,jenis,tanngal);
        call.enqueue(new Callback<Response_rekapan>() {
            @Override
            public void onResponse(Call<Response_rekapan> call, Response<Response_rekapan> response) {

                try {

                    if (response.isSuccessful()) {
                        Response_rekapan data = response.body();
                        countryView.total_uang_jalan(data.getTotalUangJalan());
                        //Toast.makeText(ctx, ""+ response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Log.i("isi_data", "onResponse: "+data);
                        if (data != null && data.getDataSetoran() != null) {
                            List<DataSetoranItem> result = data.getDataSetoran();
                            countryView.rekapan(result);
                        }
                    }
                } catch (Exception e) {
                    Log.e("onResponse", "There is an error" + e);
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Response_rekapan> call, Throwable t) {
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

//    public void simpan_pertanyaan(String jawaban,String usia) {
//        ProgressDialog  pDialog = new ProgressDialog(ctx);
//        pDialog.setMessage("Simpan Jawaban...");
//        pDialog.setCancelable(false);
//        pDialog.setCanceledOnTouchOutside(false);
//        pDialog.show();
//        ProgressDialog finalPDialog = pDialog;
//
//        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
//        Call<Response_action> sendbio = api.simpan_pertanyaan(na,usia);
//        sendbio.enqueue(new Callback<Response_action>() {
//            @Override
//            public void onResponse(Call<Response_action> call, Response<Response_action> response) {
//
//                try {
//                    String kode = response.body().getKode();
//                    countryView.status(kode,"");
//                    if (kode.equals("1")) {
//                        finalPDialog.dismiss();
//
//                        new GlideToast.makeToast((Activity) ctx, "" + response.body().getMessage(), GlideToast.LENGTHLONG, GlideToast.SUCCESSTOAST, GlideToast.CENTER).show();
//
//                    } else {
//                        finalPDialog.dismiss();
//                        new GlideToast.makeToast((Activity) ctx, "" + response.body().getMessage(), GlideToast.LENGTHLONG, GlideToast.WARNINGTOAST, GlideToast.CENTER).show();
//
//                    }
//                }catch (Exception e){
//                    Log.i("cek_error_login", "onResponse: "+e);
//                    finalPDialog.dismiss();
//                }
//
//
//
//            }
//            @Override
//            public void onFailure(Call<Response_action> call, Throwable t) {
//                Log.i("cek_info", "onFailure: "+t);
//                Log.e("cek_eror_login", "onFailure: "+t);
//
//                Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
//            }
//        });
//
//    }
//    public  void  hapus_optik(String id, ProgressDialog pDialog ){
//        pDialog = new ProgressDialog(ctx);
//        pDialog.setTitle("Mohon Tunggu!!!");
//        pDialog.setMessage("Hapus Data");
//        pDialog.setCancelable(false);
//        pDialog.setCanceledOnTouchOutside(false);
//        pDialog.show();
//        ProgressDialog finalPDialog = pDialog;
//        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
//
//        Call<Response_action> sendbio = api.hapus_optik(id);
//
//
//        sendbio.enqueue(new Callback<Response_action>() {
//            @Override
//            public void onResponse(Call<Response_action> call, Response<Response_action> response) {
//
//                String kode = response.body().getKode();
//                Log.i("kode_foto", "onResponse: " + kode);
//                countryView.status(kode,"");
//
//                if (kode.equals("1")) {
//                    finalPDialog.dismiss();
//                    new GlideToast.makeToast((Activity) ctx, "" + response.body().getMessage(), GlideToast.LENGTHLONG, GlideToast.SUCCESSTOAST, GlideToast.CENTER).show();
//
//                } else {
//
//                    finalPDialog.dismiss();
//                    new GlideToast.makeToast((Activity) ctx, "" + response.body().getMessage(), GlideToast.LENGTHLONG, GlideToast.WARNINGTOAST, GlideToast.CENTER).show();
//                }
//
//            }
//            @Override
//            public void onFailure(Call<Response_action> call, Throwable t) {
//                Log.i("cek_error", "onFailure: "+t);
//
//                Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
//            }
//        });
//
//    }

    }


