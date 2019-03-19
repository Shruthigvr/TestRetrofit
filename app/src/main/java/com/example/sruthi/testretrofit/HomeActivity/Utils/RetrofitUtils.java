package com.example.sruthi.testretrofit.HomeActivity.Utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    public static Retrofit getRetrofitAdapter()
    {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit restAdapter = new Retrofit.Builder().baseUrl(WebService.BASE_URL).client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create()).build();

        return restAdapter;
    }





}
