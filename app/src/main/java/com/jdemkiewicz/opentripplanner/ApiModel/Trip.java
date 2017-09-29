package com.jdemkiewicz.opentripplanner.ApiModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by j.demkiewicz on 28.09.2017.
 */

public class Trip {

    @SerializedName("requestParameters")
    @Expose
    private RequestParameters requestParameters;
    @SerializedName("plan")
    @Expose
    private Plan plan;
    @SerializedName("debugOutput")
    @Expose
    private DebugOutput debugOutput;
    @SerializedName("elevationMetadata")
    @Expose
    private ElevationMetadata elevationMetadata;
    @SerializedName("error")
    @Expose
    private Error error;

    public RequestParameters getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        this.requestParameters = requestParameters;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public DebugOutput getDebugOutput() {
        return debugOutput;
    }

    public void setDebugOutput(DebugOutput debugOutput) {
        this.debugOutput = debugOutput;
    }

    public ElevationMetadata getElevationMetadata() {
        return elevationMetadata;
    }

    public void setElevationMetadata(ElevationMetadata elevationMetadata) {
        this.elevationMetadata = elevationMetadata;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
