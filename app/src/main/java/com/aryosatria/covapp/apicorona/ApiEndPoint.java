package com.aryosatria.covapp.apicorona;

import com.aryosatria.covapp.model.CountryModel;
import com.aryosatria.covapp.model.RingkasanModel;
import com.aryosatria.covapp.model.RiwayatModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Aryo Wahyu Satria on 15/05/2020.
 */

public interface ApiEndPoint {
    @GET(Api.END_POINT_WORLD_HISTORY)
    Call<List<RiwayatModel>> getHistoryList(@Path("date") String date);

    @GET(Api.END_POINT_SUMMARY_WORLD)
    Call<RingkasanModel> getSummaryWorld();

    @GET(Api.END_POINT_IDN)
    Call<CountryModel> getSummaryIdn();
}
