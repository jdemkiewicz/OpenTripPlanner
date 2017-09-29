package com.jdemkiewicz.opentripplanner.ApiModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by j.demkiewicz on 28.09.2017.
 */

public class DebugOutput {

    @SerializedName("precalculationTime")
    @Expose
    private Integer precalculationTime;
    @SerializedName("pathCalculationTime")
    @Expose
    private Integer pathCalculationTime;
    @SerializedName("pathTimes")
    @Expose
    private List<Integer> pathTimes = null;
    @SerializedName("renderingTime")
    @Expose
    private Integer renderingTime;
    @SerializedName("totalTime")
    @Expose
    private Integer totalTime;
    @SerializedName("timedOut")
    @Expose
    private Boolean timedOut;

    public Integer getPrecalculationTime() {
        return precalculationTime;
    }

    public void setPrecalculationTime(Integer precalculationTime) {
        this.precalculationTime = precalculationTime;
    }

    public Integer getPathCalculationTime() {
        return pathCalculationTime;
    }

    public void setPathCalculationTime(Integer pathCalculationTime) {
        this.pathCalculationTime = pathCalculationTime;
    }

    public List<Integer> getPathTimes() {
        return pathTimes;
    }

    public void setPathTimes(List<Integer> pathTimes) {
        this.pathTimes = pathTimes;
    }

    public Integer getRenderingTime() {
        return renderingTime;
    }

    public void setRenderingTime(Integer renderingTime) {
        this.renderingTime = renderingTime;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Boolean getTimedOut() {
        return timedOut;
    }

    public void setTimedOut(Boolean timedOut) {
        this.timedOut = timedOut;
    }

}

