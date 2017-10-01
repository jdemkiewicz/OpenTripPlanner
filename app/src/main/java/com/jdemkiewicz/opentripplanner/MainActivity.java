package com.jdemkiewicz.opentripplanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.jdemkiewicz.opentripplanner.Adapter.StopsAdapter;
import com.jdemkiewicz.opentripplanner.ApiModel.Plan;
import com.jdemkiewicz.opentripplanner.Fragment.SearchFragment.SearchDialogFragment;
import com.jdemkiewicz.opentripplanner.Fragment.SearchFragment.SearchFragmentInterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements SearchFragmentInterface {
    @BindView(R.id.mainFromCoordinates)
    TextView mainFromCoordinates;
    @BindView(R.id.mainFromData)
    TextView mainFromData;
    @BindView(R.id.mainToCoordinates)
    TextView mainToCoordinates;
    @BindView(R.id.mainToData)
    TextView mainToData;
    @BindView(R.id.mainPlanCard)
    CardView mainFromToCard;
    @BindView(R.id.mainEmptyText)
    TextView mainEmptyText;
    @BindView(R.id.mainStopsContainer)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.fab)
    public void onFabClicked() {
        SearchDialogFragment searchDialogFragment = new SearchDialogFragment();
        searchDialogFragment.show(getSupportFragmentManager(), "Search");
    }

    @Override
    public void showResult(Plan plan) {
        String endTimeText = "Arrival: " + getTime(plan.getItineraries().get(0).getEndTime());
        String startTimeText = "Departure: " + getTime(plan.getItineraries().get(0).getStartTime());
        String fromCoordinates = getCoordinates(plan.getFrom().getLat(), plan.getFrom().getLon());
        String toCoordinates = getCoordinates(plan.getTo().getLat(), plan.getTo().getLon());
        setResults(fromCoordinates, toCoordinates, startTimeText, endTimeText);
        setAdapter(plan);
    }

    private String getTime(Long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d/M/y HH:mm:ss", Locale.getDefault());
        Date date = new Date(time);
        return simpleDateFormat.format(date);
    }

    private String getCoordinates(Double lat, Double lon) {
        return String.format("%s,%s", lat, lon);
    }

    private void setResults(String fromCoordinates, String toCoordinates, String startTimeText, String endTimeText) {
        mainEmptyText.setVisibility(View.GONE);
        mainFromToCard.setVisibility(View.VISIBLE);
        mainFromCoordinates.setText(fromCoordinates);
        mainToCoordinates.setText(toCoordinates);
        mainFromData.setText(startTimeText);
        mainToData.setText(endTimeText);
    }

    private void setAdapter(Plan plan) {
        StopsAdapter stopsAdapter = new StopsAdapter(plan.getItineraries().get(0).getLegs());
        recyclerView.setAdapter(stopsAdapter);
        recyclerView.setVisibility(View.VISIBLE);
    }
}
