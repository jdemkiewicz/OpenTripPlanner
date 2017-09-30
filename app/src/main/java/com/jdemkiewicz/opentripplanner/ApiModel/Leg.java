package com.jdemkiewicz.opentripplanner.ApiModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by j.demkiewicz on 28.09.2017.
 */

public class Leg {

    @SerializedName("startTime")
    @Expose
    private Long startTime;
    @SerializedName("endTime")
    @Expose
    private Long endTime;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("route")
    @Expose
    private String route;
    @SerializedName("from")
    @Expose
    private From_ from;
    @SerializedName("to")
    @Expose
    private To_ to;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public From_ getFrom() {
        return from;
    }

    public void setFrom(From_ from) {
        this.from = from;
    }

    public To_ getTo() {
        return to;
    }

    public void setTo(To_ to) {
        this.to = to;
    }

}

