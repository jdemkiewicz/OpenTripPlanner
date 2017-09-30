package com.jdemkiewicz.opentripplanner.ApiModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by j.demkiewicz on 28.09.2017.
 */

public class Itinerary {

    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("startTime")
    @Expose
    private Long startTime;
    @SerializedName("endTime")
    @Expose
    private Long endTime;
    @SerializedName("legs")
    @Expose
    private List<Leg> legs = null;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

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

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

}

