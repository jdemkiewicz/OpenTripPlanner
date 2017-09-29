package com.jdemkiewicz.opentripplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.jdemkiewicz.opentripplanner.ApiModel.Itinerary;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements SearchFragmentInterfac{
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.text)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fab)
    public void onFabClicked() {
        SearchActivity searchActivity = new SearchActivity();
        searchActivity.show(getSupportFragmentManager(), "asda");
    }

    @Override
    public void showResult(Itinerary itinerary) {

    }
}
