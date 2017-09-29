package com.jdemkiewicz.opentripplanner;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.jdemkiewicz.opentripplanner.ApiModel.Trip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends DialogFragment {
    @BindView(R.id.search_latiFrom)
    EditText search_latiFrom;
    @BindView(R.id.search_lngFrom)
    EditText search_lngFrom;

    private SearchFragmentInterfac callback;
    private MainActivity callback2;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SearchFragmentInterfac) {
            callback = ((SearchFragmentInterfac) context);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_search, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.search_searchBtn)
    public void onSearchClicked() {
        String fromPlace = String.format("%s,%s", search_latiFrom.toString(), search_lngFrom);

        OTPService otpService = getOtpService();
        otpService.getPlan("wroclaw", "51.122182,16.991945", "51.107904,17.030826", "WALK").enqueue(new Callback<Trip>() {
            @Override
            public void onResponse(Call<Trip> call, Response<Trip> response) {
                if (response.isSuccessful()) {
                    callback.showResult(response.body().getPlan().getItineraries().get(0));
                }
            }

            @Override
            public void onFailure(Call<Trip> call, Throwable t) {
            }
        });
    }

    private OTPService getOtpService() {
        ApiClient apiClient = new ApiClient();
        return apiClient.getRetrofit().create(OTPService.class);
    }
}
