package com.example.cv_dpr.presnter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cv_dpr.model.rekapan.DataSetoranItem;
import com.example.cv_dpr.model.rekapan.Response_rekapan;
import com.example.cv_dpr.model.mobil.DataMobilItem;
import com.example.cv_dpr.model.mobil.Response_mobil;
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
    int id_pemilik_mobil,id_mobil;
    private List<String> nama_sopir_array = new ArrayList<String>();
    private List<String> nama_pemilik_mobil_array = new ArrayList<String>();
    private List<Integer> pemilik_mobil_id= new ArrayList<Integer>();
    private List<Integer> mobil_id = new ArrayList<Integer>();
    public mobil(mobil_view view, Context ctx) {
        this.countryView = view;
        this.ctx = ctx;

        if (this.countryService == null) {
            this.countryService = new Retroserver_server_AUTH();
        }
    }

    public void get_mobil() {
        ApiRequest api = Retroserver_server_AUTH.getClient().create(ApiRequest.class);
        Call<Response_mobil> call = api.get_mobil();
        call.enqueue(new Callback<Response_mobil>() {
            @Override
            public void onResponse(Call<Response_mobil> call, Response<Response_mobil> response) {
                Response_mobil data = response.body();
                List<DataMobilItem> result = data.getDataMobil();
                nama_sopir_array.clear();
                nama_pemilik_mobil_array.clear();
                pemilik_mobil_id.clear();
                mobil_id.clear();

                for (int i = 0; i < result.size(); i++) {
                    id_pemilik_mobil = result.get(i).getPemilikMobilId();
                    id_mobil = result.get(i).getId();
                    nama_sopir = result.get(i).getNamaSopir();
                    nama_pemilik_mobil = result.get(i).getPemilikMobil().get(0).getNama();
                    nama_sopir_array.add(nama_sopir);
                    nama_pemilik_mobil_array.add(nama_pemilik_mobil);
                    pemilik_mobil_id.add(id_pemilik_mobil);
                    mobil_id.add(id_mobil);

                }
                spinnerDialog = new SpinnerDialog((AppCompatActivity) ctx, (ArrayList<String>) nama_sopir_array, "Pilih Sopir Mobil");
                spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
                    @Override
                    public void onClick(String item, int position) {
                        String nama_sop = nama_sopir_array.get(position);
                        String nama_pemilik = nama_pemilik_mobil_array.get(position);
                        int id_pemilik = pemilik_mobil_id.get(position);
                        int id_mobil = mobil_id.get(position);
                        Toast.makeText(ctx, ""+nama_sopir_array.get(position), Toast.LENGTH_SHORT).show();
                        countryView.data_sopir(nama_sop,nama_pemilik,id_pemilik,id_mobil);


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


