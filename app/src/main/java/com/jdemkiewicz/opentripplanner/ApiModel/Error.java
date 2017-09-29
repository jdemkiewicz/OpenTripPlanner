package com.jdemkiewicz.opentripplanner.ApiModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by j.demkiewicz on 29.09.2017.
 */

public class Error {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("missing")
    @Expose
    private List<String> missing = null;
    @SerializedName("noPath")
    @Expose
    private Boolean noPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getMissing() {
        return missing;
    }

    public void setMissing(List<String> missing) {
        this.missing = missing;
    }

    public Boolean getNoPath() {
        return noPath;
    }

    public void setNoPath(Boolean noPath) {
        this.noPath = noPath;
    }
}
