package com.jdemkiewicz.opentripplanner.ApiModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by j.demkiewicz on 28.09.2017.
 */

public class ElevationMetadata {

    @SerializedName("ellipsoidToGeoidDifference")
    @Expose
    private Double ellipsoidToGeoidDifference;
    @SerializedName("geoidElevation")
    @Expose
    private Boolean geoidElevation;

    public Double getEllipsoidToGeoidDifference() {
        return ellipsoidToGeoidDifference;
    }

    public void setEllipsoidToGeoidDifference(Double ellipsoidToGeoidDifference) {
        this.ellipsoidToGeoidDifference = ellipsoidToGeoidDifference;
    }

    public Boolean getGeoidElevation() {
        return geoidElevation;
    }

    public void setGeoidElevation(Boolean geoidElevation) {
        this.geoidElevation = geoidElevation;
    }

}
