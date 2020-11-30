package com.aryosatria.covapp.apicorona;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aryo Wahyu Satria on 15/05/2020.
 */

public class ApiService {

    public static Retrofit getRetrofitService() {
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
