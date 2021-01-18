package com.example.project.ui.login.networkmanager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginRetrofitBuilder {
    private static Retrofit instance;

    private LoginRetrofitBuilder() {
        //private constructor
    }

    public static Retrofit getInstance() {
        if(instance == null) {
            synchronized (LoginRetrofitBuilder.class) {
                if(instance == null) {
                    instance = new Retrofit.Builder()
                            .baseUrl("https://localhost:8080/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(new OkHttpClient())
                            .build();
                }
            }
        }
        return instance;
    }
}
