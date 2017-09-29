package com.jdemkiewicz.opentripplanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.jdemkiewicz.opentripplanner.ApiModel.Itinerary;
import com.jdemkiewicz.opentripplanner.ApiModel.Plan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements SearchFragmentInterface {
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
        SearchDialogFragment searchDialogFragment = new SearchDialogFragment();
        searchDialogFragment.show(getSupportFragmentManager(), "asda");
    }

    @Override
    public void showResult(Plan plan) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("kk:mm", Locale.getDefault());
        Date date = new Date(plan.getDate());
        String formatedDate = simpleDateFormat.format(date);
        Toast.makeText(getApplicationContext(), formatedDate, Toast.LENGTH_LONG).show();
    }
}
