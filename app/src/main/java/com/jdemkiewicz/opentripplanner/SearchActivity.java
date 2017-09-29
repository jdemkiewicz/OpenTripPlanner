package com.jdemkiewicz.opentripplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.jdemkiewicz.opentripplanner.ApiModel.JSON;
import com.jdemkiewicz.opentripplanner.ApiModel.Plan;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.search_latiFrom)
    EditText search_latiFrom;
    @BindView(R.id.search_lngFrom)
    EditText search_lngFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.search_searchBtn)
    public void onSearchClicked() {
        String fromPlace = String.format("%s,%s", search_latiFrom.toString(), search_lngFrom);

        OTPService otpService = getOtpService();
        otpService.getPlan("wroclaw", fromPlace, "51.107904,17.030826").enqueue(new Callback<JSON>() {
            @Override
            public void onResponse(Call<JSON> call, Response<JSON> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), response.body().getPlan().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JSON> call, Throwable t) {

            }
        });
    }

    private OTPService getOtpService() {
        ApiClient apiClient = new ApiClient();
        return apiClient.getRetrofit().create(OTPService.class);
    }
}
