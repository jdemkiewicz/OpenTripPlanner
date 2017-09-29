package com.jdemkiewicz.opentripplanner.ApiModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by j.demkiewicz on 28.09.2017.
 */

public class Step {

    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("relativeDirection")
    @Expose
    private String relativeDirection;
    @SerializedName("streetName")
    @Expose
    private String streetName;
    @SerializedName("absoluteDirection")
    @Expose
    private String absoluteDirection;
    @SerializedName("stayOn")
    @Expose
    private Boolean stayOn;
    @SerializedName("area")
    @Expose
    private Boolean area;
    @SerializedName("bogusName")
    @Expose
    private Boolean bogusName;
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("elevation")
    @Expose
    private List<Object> elevation = null;

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getRelativeDirection() {
        return relativeDirection;
    }

    public void setRelativeDirection(String relativeDirection) {
        this.relativeDirection = relativeDirection;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAbsoluteDirection() {
        return absoluteDirection;
    }

    public void setAbsoluteDirection(String absoluteDirection) {
        this.absoluteDirection = absoluteDirection;
    }

    public Boolean getStayOn() {
        return stayOn;
    }

    public void setStayOn(Boolean stayOn) {
        this.stayOn = stayOn;
    }

    public Boolean getArea() {
        return area;
    }

    public void setArea(Boolean area) {
        this.area = area;
    }

    public Boolean getBogusName() {
        return bogusName;
    }

    public void setBogusName(Boolean bogusName) {
        this.bogusName = bogusName;
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

    public List<Object> getElevation() {
        return elevation;
    }

    public void setElevation(List<Object> elevation) {
        this.elevation = elevation;
    }

}

