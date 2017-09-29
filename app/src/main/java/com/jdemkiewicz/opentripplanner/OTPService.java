package com.jdemkiewicz.opentripplanner;

import com.jdemkiewicz.opentripplanner.ApiModel.JSON;
import com.jdemkiewicz.opentripplanner.ApiModel.Plan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by j.demkiewicz on 28.09.2017.
 */

public interface OTPService {
    @Headers("Accept: application/json")
    @GET("routers/{path}/plan")
    Call<JSON> getPlan(@Path("path") String path, @Query("fromPlace") String fromPlace, @Query("toPlace") String toPlace);
}
