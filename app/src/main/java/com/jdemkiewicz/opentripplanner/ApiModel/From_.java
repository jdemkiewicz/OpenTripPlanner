package com.jdemkiewicz.opentripplanner.ApiModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by j.demkiewicz on 28.09.2017.
 */

public class From_ {

    @SerializedName("name")
    @Expose
    protected String name;
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("departure")
    @Expose
    private Long departure;
    @SerializedName("orig")
    @Expose
    private String orig;
    @SerializedName("vertexType")
    @Expose
    private String vertexType;
    @SerializedName("stopId")
    @Expose
    private String stopId;
    @SerializedName("stopCode")
    @Expose
    private String stopCode;
    @SerializedName("arrival")
    @Expose
    private Long arrival;
    @SerializedName("stopIndex")
    @Expose
    private Integer stopIndex;
    @SerializedName("stopSequence")
    @Expose
    private Integer stopSequence;

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

    public String getVertexType() {
        return vertexType;
    }

    public void setVertexType(String vertexType) {
        this.vertexType = vertexType;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopCode() {
        return stopCode;
    }

    public void setStopCode(String stopCode) {
        this.stopCode = stopCode;
    }

    public Long getArrival() {
        return arrival;
    }

    public void setArrival(Long arrival) {
        this.arrival = arrival;
    }

    public Integer getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(Integer stopIndex) {
        this.stopIndex = stopIndex;
    }

    public Integer getStopSequence() {
        return stopSequence;
    }

    public void setStopSequence(Integer stopSequence) {
        this.stopSequence = stopSequence;
    }

}
