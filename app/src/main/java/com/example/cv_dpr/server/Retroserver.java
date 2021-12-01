package com.example.cv_dpr.server;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retroserver {
    private  static  final String base_url = "http://10.1.4.63/cv_dpr/public/api/";
   //private  static  final String base_url =    "http://192.168.56.1/e_pelayanan/";

    public static  final String base_url_image_before = "https://sipaten.jambikota.go.id/android/images/before/";
    public static  final String base_url_image_after = "https://sipaten.jambikota.go.id/android/images/after/";
    public static  final String base_url_image_user = "https://sipaten.jambikota.go.id/android/images/user/";
    public static  final String url_register = "https://sipaten.jambikota.go.id/android/register.php";
    public static  final String url_kirim_laporan_user = "https://sipaten.jambikota.go.id/android/kirim_laporan.php";
    public static  final String url_login = "https://sipaten.jambikota.go.id/android/Login.php";

    private static Retrofit retrofit;
    public static Retrofit getClient()
    {
        if(retrofit == null)
        {
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(5, TimeUnit.SECONDS)
                    .readTimeout(5, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .build();
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }


}
