package com.example.myretrofit.dao;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private RetrofitBuilder() {}

    private static Retrofit retrofit = null;

    public static Retrofit build() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com/repositories/1300192/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit;
        }
        else {
            return retrofit;
        }
    }
}
