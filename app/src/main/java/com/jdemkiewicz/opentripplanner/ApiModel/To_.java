package com.jdemkiewicz.opentripplanner.ApiModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by j.demkiewicz on 28.09.2017.
 */

public class To_ {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("arrival")
    @Expose
    private Long arrival;
    @SerializedName("departure")
    @Expose
    private Long departure;
    @SerializedName("orig")
    @Expose
    private String orig;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Long getArrival() {
        return arrival;
    }

    public void setArrival(Long arrival) {
        this.arrival = arrival;
    }

    public Long getDeparture() {
        return departure;
    }

    public void setDeparture(Long departure) {
        this.departure = departure;
    }

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

}
