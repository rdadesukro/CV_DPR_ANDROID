package com.example.cv_dpr.server;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retroserver_server_AUTH {
    private  static  final String base_url = "http://192.168.43.48/cv_dpr/public/api/";
    public static Retrofit getClient() {
        OkHttpClient client = new OkHttpClient.Builder().callTimeout(2, TimeUnit.MINUTES)
                .callTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request newRequest  = chain.request().newBuilder()
                                .addHeader("Authorization", "Bearer " + "3|0Lz7CyqiUXM9QCB1qf0lYgKUrp5afoTYAwOi8VFT")
                                .build();
                        return chain.proceed(newRequest);
                    }

                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit;

    }


}
