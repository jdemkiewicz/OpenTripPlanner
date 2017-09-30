package com.jdemkiewicz.opentripplanner;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by j.demkiewicz on 28.09.2017.
 */

public class ApiClient {
    private static final String BASE_URL = "http://79.137.82.41:9000/otp/";
    private Retrofit retrofit;

    public ApiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }
}


