package com.example.cv_dpr.presnter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.cv_dpr.model.pemilik_mobil.DataPemilikMobilItem;
import com.example.cv_dpr.model.pemilik_mobil.Response_pemilik_mobil;
import com.example.cv_dpr.server.ApiRequest;
import com.example.cv_dpr.server.Retroserver_server_AUTH;
import com.example.cv_dpr.view.pemilik_mobil_view;
import com.example.spinner_dialog.SpinnerDialog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

;

public class pemilik_mobil {

    private Context ctx;
    private pemilik_mobil_view countryView;
    private Retroserver_server_AUTH countryService;
    SpinnerDialog spinnerDialog;
    String nama_sopir,nama_pemilik_mobil;
    int id_pemilik_mobil,id_mobil;
    private List<String> nama_sopir_array = new ArrayList<String>();
    private List<String> nama_pemilik_mobil_array = new ArrayList<String>();
    private List<Integer> pemilik_mobil_id= new ArrayList<Integer>();
    private List<Integer> mobil_id = new ArrayList<Integer>();
    public pemilik_mobil(pemilik_mobil_view view, Context ctx) {
        this.countryView = view;
        this.ctx = ctx;

        if (this.countryService == null) {
            this.countryService = new Retroserver_server_AUTH();
        }
    }



    public void simpan_uang_jalan(int nama_sopir,int nama_pemilik_mobil,String uang_jalan,String jenis,String id) {
        ProgressDialog pDialog = new ProgressDialog(ctx);
        pDialog = new ProgressDialog(ctx);
        pDialog.setTitle("Mohon Tunggu!!!");
        pDialog.setMessage("Simpan Data...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.show();
        ProgressDialog finalPDialog = pDialog;
        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
        Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> sendbio;

         if (jenis.equals("new")){
             sendbio = api.simpan_uang_jalan(nama_sopir,nama_pemilik_mobil,uang_jalan);
         }else {
             sendbio = api.edit_uang_jalan(nama_sopir,nama_pemilik_mobil,uang_jalan,id);
         }


        ProgressDialog finalPDialog1 = pDialog;
        sendbio.enqueue(new Callback<com.example.cv_dpr.model.rekapan.aksi.Response_aksi>() {
            @Override
            public void onResponse(Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> call, Response<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> response) {
                try {
                   String kode = response.body().getKode();
                    String pesan = response.body().getMessage();
                    //adasdas
                    Log.i("cek_error_login", "onResponse: "+response.body());
                    if (kode.equals("1")) {
                        countryView.sukses(pesan);
                        finalPDialog1.dismiss();

                    } else {
                        countryView.gagal(pesan);
                        finalPDialog1.dismiss();
                    }
                }catch (Throwable e){
                    Toast.makeText(ctx, ""+response.code(), Toast.LENGTH_SHORT).show();
                    Log.i("cek_error_login", "onResponse: "+e);
                    finalPDialog.dismiss();
                }

            }
            @Override
            public void onFailure(Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> call, Throwable t) {
                Log.e("cek_eror_login", "onFailure: "+t);

                Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
            }
        });

    }
    public void get_pemilik_mobil() {

        ProgressDialog pDialog = new ProgressDialog(ctx);
//        pDialog = new ProgressDialog(ctx);
//        pDialog.setMessage("Mencari Data...");
//        pDialog.setCancelable(false);
//        pDialog.setCanceledOnTouchOutside(false);
//        pDialog.show();
//        ProgressDialog finalPDialog = pDialog;
//        finalPDialog.setCanceledOnTouchOutside(true);
        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
        Log.i("isi_server", "isi_server: "+Retroserver_server_AUTH.getClient().baseUrl());

        Call<Response_pemilik_mobil> call = api.get_pemilik_mobil();
        call.enqueue(new Callback<Response_pemilik_mobil>() {
            @Override
            public void onResponse(Call<Response_pemilik_mobil> call, Response<Response_pemilik_mobil> response) {

                try {

                    if (response.isSuccessful()) {
                        Response_pemilik_mobil data = response.body();
                        //Toast.makeText(ctx, ""+ response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Log.i("isi_data", "onResponse: "+data);
                        if (data != null && data.getDataPemilikMobil() != null) {
                            List<DataPemilikMobilItem> result = data.getDataPemilikMobil();
                            countryView.pemilik_mobil(result);
                        }


                    }
                } catch (Exception e) {
                   // finalPDialog.dismiss();
                    Toast.makeText(ctx, ""+e, Toast.LENGTH_SHORT).show();
                    Log.e("onResponse", "There is an error" + e);
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Response_pemilik_mobil> call, Throwable t) {
                t.printStackTrace();
              //  finalPDialog.dismiss();
                Log.i("cek_error", "onFailure: " + t);
                if (t instanceof IOException) {

                    Log.i("cek_error", "onFailure: " + t);
                } else {

                    Log.i("cek_error", "onFailure: " + t);
                }
            }
        });
    }
    public void simpan_setoran(int nama_sopir,int nama_pemilik_mobil,String uang_jalan,String jenis,String id) {
        ProgressDialog pDialog = new ProgressDialog(ctx);
        pDialog = new ProgressDialog(ctx);
        pDialog.setTitle("Mohon Tunggu!!!");
        pDialog.setMessage("Simpan Data...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.show();
        ProgressDialog finalPDialog = pDialog;
        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
        Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> sendbio;

        if (jenis.equals("new")){
            sendbio = api.simpan_uang_jalan(nama_sopir,nama_pemilik_mobil,uang_jalan);
        }else {
            sendbio = api.edit_uang_jalan(nama_sopir,nama_pemilik_mobil,uang_jalan,id);
        }


        ProgressDialog finalPDialog1 = pDialog;
        sendbio.enqueue(new Callback<com.example.cv_dpr.model.rekapan.aksi.Response_aksi>() {
            @Override
            public void onResponse(Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> call, Response<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> response) {
                try {
                    String kode = response.body().getKode();
                    String pesan = response.body().getMessage();
                    //adasdas
                    Log.i("cek_error_login", "onResponse: "+response.body());
                    if (kode.equals("1")) {
                        countryView.sukses(pesan);
                        finalPDialog1.dismiss();

                    } else {
                        countryView.gagal(pesan);
                        finalPDialog1.dismiss();
                    }
                }catch (Throwable e){
                    Toast.makeText(ctx, ""+response.code(), Toast.LENGTH_SHORT).show();
                    Log.i("cek_error_login", "onResponse: "+e);
                    finalPDialog.dismiss();
                }

            }
            @Override
            public void onFailure(Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> call, Throwable t) {
                Log.e("cek_eror_login", "onFailure: "+t);

                Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
            }
        });

    }

    public void simpan_pemilik_mobil(String id,String nama,String jumlah_unit,String jenis) {
        ProgressDialog pDialog = new ProgressDialog(ctx);
        pDialog = new ProgressDialog(ctx);
        pDialog.setTitle("Mohon Tunggu!!!");
        pDialog.setMessage("Simpan Data...");
        pDialog.setCancelable(false);
        pDialog.setCanceledOnTouchOutside(false);
        pDialog.show();
        ProgressDialog finalPDialog = pDialog;
        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
        Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> sendbio;

        if (jenis.equals("new")){
            sendbio = api.simpan_pemilik_mobil(nama,jumlah_unit);
        }else {
            sendbio = api.edit_pemilik_mobil(id,nama,jumlah_unit);
        }

        Log.i("Data_data", "simpan_pemilik_mobil: "+jumlah_unit+" "+jenis+" "+id+" "+id);


        ProgressDialog finalPDialog1 = pDialog;
        sendbio.enqueue(new Callback<com.example.cv_dpr.model.rekapan.aksi.Response_aksi>() {
            @Override
            public void onResponse(Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> call, Response<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> response) {
                try {
                    String kode = response.body().getKode();
                    String pesan = response.body().getMessage();
                    //adasdas
                    Log.i("cek_error_login", "onResponse: "+response.body());
                    if (kode.equals("1")) {
                        countryView.sukses(pesan);
                        finalPDialog1.dismiss();

                    } else {
                        countryView.gagal(pesan);
                        finalPDialog1.dismiss();
                    }
                }catch (Throwable e){
                    Toast.makeText(ctx, ""+response.code(), Toast.LENGTH_SHORT).show();
                    Log.i("cek_error_login", "onResponse: "+e);
                    finalPDialog.dismiss();
                }

            }
            @Override
            public void onFailure(Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> call, Throwable t) {
                Log.e("cek_eror_login", "onFailure: "+t);

                Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
            }
        });

    }
//    public void simpan_setoran(String jenis,String tgl_muat,String tgl_bongkar,String berat_muat,String) {
//        ProgressDialog pDialog = new ProgressDialog(ctx);
//        pDialog = new ProgressDialog(ctx);
//        pDialog.setTitle("Mohon Tunggu!!!");
//        pDialog.setMessage("Simpan Data...");
//        pDialog.setCancelable(false);
//        pDialog.setCanceledOnTouchOutside(false);
//        pDialog.show();
//        ProgressDialog finalPDialog = pDialog;
//        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
//        Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> sendbio;
//
//        if (jenis.equals("new")){
//            sendbio = api.simpan_uang_jalan(nama_sopir,nama_pemilik_mobil,"uang_jalan");
//        }else {
//            sendbio = api.edit_uang_jalan(nama_sopir,nama_pemilik_mobil,uang_jalan,id);
//        }
//
//
//        ProgressDialog finalPDialog1 = pDialog;
//        sendbio.enqueue(new Callback<com.example.cv_dpr.model.rekapan.aksi.Response_aksi>() {
//            @Override
//            public void onResponse(Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> call, Response<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> response) {
//                try {
//                    String kode = response.body().getKode();
//                    String pesan = response.body().getMessage();
//                    //adasdas
//                    Log.i("cek_error_login", "onResponse: "+response.body());
//                    if (kode.equals("1")) {
//                        countryView.sukses(pesan);
//                        finalPDialog1.dismiss();
//
//                    } else {
//                        countryView.gagal(pesan);
//                        finalPDialog1.dismiss();
//                    }
//                }catch (Throwable e){
//                    Toast.makeText(ctx, ""+response.code(), Toast.LENGTH_SHORT).show();
//                    Log.i("cek_error_login", "onResponse: "+e);
//                    finalPDialog.dismiss();
//                }
//
//            }
//            @Override
//            public void onFailure(Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> call, Throwable t) {
//                Log.e("cek_eror_login", "onFailure: "+t);
//
//                Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
//            }
//        });
//
//    }

    }


