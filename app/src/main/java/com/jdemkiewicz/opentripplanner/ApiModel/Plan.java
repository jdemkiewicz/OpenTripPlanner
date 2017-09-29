package com.jdemkiewicz.opentripplanner.ApiModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by j.demkiewicz on 28.09.2017.
 */

public class Plan {
    @SerializedName("date")
    @Expose
    private Long date;
    @SerializedName("from")
    @Expose
    private From from;
    @SerializedName("to")
    @Expose
    private To to;
    @SerializedName("itineraries")
    @Expose
    private List<Itinerary> itineraries = null;

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public To getTo() {
        return to;
    }

    public void setTo(To to) {
        this.to = to;
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "date=" + date +
                ", from=" + from +
                ", to=" + to +
                ", itineraries=" + itineraries +
                '}';
    }
}
