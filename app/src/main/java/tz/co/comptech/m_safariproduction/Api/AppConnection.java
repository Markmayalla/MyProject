package tz.co.comptech.m_safariproduction.Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
    Created in 05/11/2018

    This file used to provide root server url
        e.g
            www.m-safariapp.com/api/mob
 */
public class AppConnection {
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://52.47.72.148:9999/api-android-v1/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .client(client)
                .build();
        return retrofit;
    }
}


