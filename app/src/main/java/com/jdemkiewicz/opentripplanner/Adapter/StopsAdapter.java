package com.jdemkiewicz.opentripplanner.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jdemkiewicz.opentripplanner.ApiModel.Leg;
import com.jdemkiewicz.opentripplanner.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by j.demkiewicz on 30.09.2017.
 */

public class StopsAdapter extends RecyclerView.Adapter<StopsAdapter.StopsViewHolder> {
    private List<Leg> stopsList;

    public StopsAdapter(List<Leg> stopsList) {
        this.stopsList = stopsList;
    }

    @Override
    public StopsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stops_card_layout, parent, false);
        return new StopsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StopsViewHolder holder, int position) {
        Leg leg = stopsList.get(position);
        holder.mode.setText(leg.getMode() + " " + leg.getRoute());
        holder.from.setText(leg.getFrom().getName());
        holder.destination.setText(leg.getTo().getName());
        holder.fromCoordinates.setText(getCoordinates(leg.getFrom().getLat(), leg.getFrom().getLon()));
        holder.toCoordinates.setText(getCoordinates(leg.getTo().getLat(), leg.getTo().getLon()));
        holder.fromData.setText(getTime(leg.getFrom().getDeparture()));
        holder.toData.setText(getTime(leg.getTo().getArrival()));
    }

    private String getCoordinates(Double lat, Double lon) {
        return String.format("%s,%s", lat, lon);
    }

    private String getTime(Long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d/M/y HH:mm:ss", Locale.getDefault());
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }

    @Override
    public int getItemCount() {
        return stopsList.size();
    }

    public static class StopsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.stopsCardLayout)
        CardView stopsCardLayout;
        @BindView(R.id.stopsCardOrigin)
        TextView from;
        @BindView(R.id.stopsCardDestination)
        TextView destination;
        @BindView(R.id.stopsCardMode)
        TextView mode;
        @BindView(R.id.stopsCardFromCoordinates)
        TextView fromCoordinates;
        @BindView(R.id.stopsCardToCoordinates)
        TextView toCoordinates;
        @BindView(R.id.stopsCardFromData)
        TextView fromData;
        @BindView(R.id.stopsCardToData)
        TextView toData;

        public StopsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
