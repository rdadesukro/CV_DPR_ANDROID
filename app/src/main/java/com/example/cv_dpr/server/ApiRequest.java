package com.example.cv_dpr.server;


import com.example.cv_dpr.model.mobil.Response_mobil;
import com.example.cv_dpr.model.pembyaran.Response_pembayaran;
import com.example.cv_dpr.model.pemilik_mobil.Response_pemilik_mobil;
import com.example.cv_dpr.model.rekapan.Response_rekapan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiRequest {



//    @Multipart
//    @POST("edit_foto_profil")
//    Call<Response_login> edit_foto(@Part MultipartBody.Part foto);
//
//    @FormUrlEncoded
//    @POST("user/register")
//    Call<Response_login> register(
//            @Field("nim") String nim,
//            @Field("username") String username,
//            @Field("nama_lengkap") String nama_lengkap,
//            @Field("password") String password,
//            @Field("konfirmasi_password") String konfirmasi_password);
//
//    @FormUrlEncoded
//    @POST("user/jawaban/kirim")
//    Call<Response_simpan_data> simpan_semua_data(
//            @Field("nama_balita") String nama,
//            @Field("tanggal_lahir") String tgl_lahir,
//            @Field("nama_ibu") String nama_ibu,
//            @Field("alamat") String alamat,
//            @Field("usia_dalam_bulan") String usia_dalam_bulan,
//            @Field("jenis_kelamin") String jenis_kelamin,
//            @Field("berat") String berat_badan,
//            @Field("panjang") String panjang_badan,
//            @Field("kode_pertumbuhan") String pertumbuhan_kode,
//            @Field("kode_rekomendasi") String rekomendasi_kode,
//            @Field("kode_tindakan_perkembangan") String kode_tindakan_perkembangan,
//            @Field("jawaban_array") String jawaban_array);
//
//
//    @FormUrlEncoded
//    @POST("riset_password")
//    Call<Response_action> edit_password(
//            @Field("kode") String kode,
//            @Field("email") String email,
//            @Field("password_baru") String password_baru);
//
//
//
//
//
//    @FormUrlEncoded
//    @POST("user/password/ubah")
//    Call<Response_login> edit_pass(
//            @Field("pass_lama") String password,
//            @Field("pass_baru") String password_baru);
//
//
//
//
//    @GET("sliders")
//    Call<Response_slider> get_slider();
//
//
//
//
//
//    @FormUrlEncoded
//    @POST("user/login")
//    Call<Response_login> login(
//            @Field("username") String username,
//            @Field("password") String password);
//
//    @FormUrlEncoded
//    @POST("user/password/reset")
//    Call<Response_simpan_data> riset(
//            @Field("username") String username,
//            @Field("nim") String nim);
//
//
//
////
////    @GET("penilaian/{tgl_lahir}")
////    Call<Response_pertanyaan> get_pertanyaan(
////            @Path("tgl_lahir") String tgl_lahir);
//
//    @GET("balita/perkembangan/{tgl_lahir}")
//    Call<Response_pertanyaan> get_pertanyaan(@Path("tgl_lahir") String tgl_lahir);
//
    @FormUrlEncoded
    @POST("auth/tampil_uang_jalan")
    Call<Response_rekapan> get_uang_jalan(@Field("tanggal") String tanggal,
                                          @Field("nama_sopir") String nama_sopir,
                                          @Field("jenis") String jenis,
                                          @Field("mobil_id") String mobil_id);

    @FormUrlEncoded
    @POST("auth/rekapan")
    Call<Response_pembayaran> get_rekapan(@Field("id") String id,
                                          @Field("jenis") String jenis,
                                          @Field("waktu") String waktu,
                                          @Field("from") String from,
                                          @Field("to") String to);



    @FormUrlEncoded
    @POST("auth/simpan_setoran")
    Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> simpan_uang_jalan(@Field("mobil_id") int mobil_id,
                                                                                @Field("pemilik_mobil_id") int pemilik_mobil_id,
                                                                                @Field("uang_jalan") String uang_jalan);


    @FormUrlEncoded
    @POST("auth/simpan_mobil")
    Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> simpan_mobil(@Field("nama_sopir") String nama,
                                                                           @Field("pemilik_mobil_id") int pemilik_mobil_id,
                                                                           @Field("jenis") String jenis,
                                                                           @Field("nopol") String nopol);

    @FormUrlEncoded
    @POST("auth/simpan_pemilik_mobil")
    Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> simpan_pemilik_mobil(@Field("nama") String nama,
                                                                                @Field("jumlah_unit") String pemilik_mobil_id);


    @FormUrlEncoded
    @POST("auth/edit_uang_jalan")
    Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> edit_uang_jalan(@Field("mobil_id") int mobil_id,
                                                                                @Field("pemilik_mobil_id") int pemilik_mobil_id,
                                                                                @Field("uang_jalan") String uang_jalan,
                                                                              @Field("id") String id);


    @FormUrlEncoded
    @POST("auth/edit_setoran")
    Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> edit_setoran(@Field("id") int id,
                                                                              @Field("harga") String harga,
                                                                              @Field("tgl_muat") String tgl_muat,
                                                                              @Field("tgl_bongkar") String tgl_bongkar,
                                                                           @Field("berat_muat") String berat_muat,
                                                                           @Field("berat_bongkar") String berat_bongkar,
                                                                           @Field("tujuan") String tujuan,
                                                                           @Field("transportir_id") String transportir_id);

    @FormUrlEncoded
    @POST("auth/edit_mobil")
    Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> edit_mobil(@Field("id") int id,
                                                                              @Field("pemilik_mobil_id") int pemilik_mobil_id,
                                                                              @Field("jenis") String jenis,
                                                                              @Field("nopol") String nopol,
                                                                         @Field("nama_sopir") String nama_sopir);




    @FormUrlEncoded
    @POST("auth/edit_pemilik_mobil")
    Call<com.example.cv_dpr.model.rekapan.aksi.Response_aksi> edit_pemilik_mobil(@Field("id") String id,
                                                                              @Field("nama") String nama,
                                                                              @Field("jumlah_unit") String jumlah_unit);

    @GET("auth/tampil_setoran")
    Call<Response_rekapan> get_setoran();



    @FormUrlEncoded
    @POST("auth/tampil_setoran")
    Call<Response_rekapan> tampil_setoran(@Field("mobil_id") String mobil_id,
                                          @Field("nama_sopir") String nama_sopir,
                                          @Field("jenis") String jenis,
                                          @Field("tanngal") String tanngal);

    @GET("auth/tampil_mobil")
    Call<Response_mobil> get_mobil();

    @GET("auth/pemilik_mobil")
    Call<Response_pemilik_mobil> get_pemilik_mobil();

    @GET("auth/tampil_mobil")
    Call<Response_mobil> get_sopir();
//
//
//    @GET("user/jawaban/histori/admin")
//    Call<Response_history> get_history_admin();
//
//
//    @GET("user/jawaban/histori/detail/{id}")
//    Call<Response_detail_history> get_history_detail(@Path("id") String id);
//
//    @GET("balita/umur/{tgl_lahir}")
//    Call<Response_umur> get_umur(
//            @Path("tgl_lahir") String tgl_lahir);
//
//    @FormUrlEncoded
//    @POST("balita/perkembangan/hasil")
//    Call<Response_perkembangan> get_perkembangan(
//            @Field("tgl_lahir") String tgl_lahir,
//            @Field("jawaban") String jawaban);
//
//
//    @FormUrlEncoded
//    @POST("balita/pertumbuhan")
//    Call<Response_rekomendasi> get_rekomendasi(
//            @Field("berat_badan") double berat_badan,
//            @Field("jenis_kelamin") String jenis_kelamin,
//            @Field("usia_dalam_bulan") String usia_dalam_bulan);
//
//
//    @POST("image/data_materi.json")
//    Call<Response_materi> get_materi();
//
//
//
//    @FormUrlEncoded
//    @POST("simpan_pertanyaan")
//    Call<Response_action> simpan_curhatan(@Field("isi_pertanyaan") String isi_pertanyaan);
//
//    @FormUrlEncoded
//    @POST("cek_data")
//    Call<Response_login> cek_data(
//            @Field("email") String username,
//              @Field("password") String password);
//
//
//
//    @POST("user/logout")
//    Call<Response_login> logout();
//
//

}


