package com.jdemkiewicz.opentripplanner;

import com.jdemkiewicz.opentripplanner.ApiModel.Trip;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by j.demkiewicz on 28.09.2017.
 */

public interface OTPService {
    @GET("routers/{path}/plan")
    Call<Trip> getPlan(@Path("path") String path, @Query("fromPlace") String fromPlace, @Query("toPlace") String toPlace,
                       @Query("mode") String mode);
}
