package com.jdemkiewicz.opentripplanner.ApiModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by j.demkiewicz on 28.09.2017.
 */

public class Trip {
    @SerializedName("plan")
    @Expose
    private Plan plan;
    @SerializedName("error")
    @Expose
    private Error error;

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
