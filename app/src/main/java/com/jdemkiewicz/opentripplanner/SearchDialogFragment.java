package com.jdemkiewicz.opentripplanner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jdemkiewicz.opentripplanner.ApiModel.Trip;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchDialogFragment extends DialogFragment {
    @BindView(R.id.search_latitudeFrom)
    EditText latitudeFromEditText;
    @BindView(R.id.search_longitudeFrom)
    EditText longitudeFromEditText;
    @BindView(R.id.search_latitudeTo)
    EditText latitudeToEditText;
    @BindView(R.id.search_longitudeTo)
    EditText longitudeToEditText;
    @BindView(R.id.search_town)
    EditText townEditText;
    @BindView(R.id.search_checkBoxContainer)
    LinearLayout checkBoxContainer;
    private View view;

    private SearchFragmentInterface callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SearchFragmentInterface) {
            callback = ((SearchFragmentInterface) context);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_dialog, container, false);
        ButterKnife.bind(this, view);
        setUpCheckBoxes();
        return view;
    }

    private void setUpCheckBoxes() {
        for (final ModeEnum modeEnum : ModeEnum.values()) {
            final CheckBox checkBox = new CheckBox(getActivity());
            checkBox.setText(modeEnum.getTitle());
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    modeEnum.setChecked(checkBox.isChecked());
                    Log.d("Enum", String.valueOf(modeEnum) + ": " + String.valueOf(modeEnum.isChecked()));
                }
            });
            checkBoxContainer.addView(checkBox);
        }
    }

    @OnClick(R.id.search_dismiss)
    public void onCloseClicked() {
        dismiss();
    }

    //"51.122182,16.991945", "51.107904,17.030826"

    @OnClick(R.id.search_searchBtn)
    public void onSearchClicked() {
        String fromPlace = getPlaceParam(latitudeFromEditText, longitudeFromEditText);
        String toPlace = getPlaceParam(latitudeToEditText, longitudeToEditText);
        String path = townEditText.getText().toString().toLowerCase();
        OTPService otpService = getOtpService();
        otpService.getPlan(path, fromPlace, toPlace, getModeParams())
                .enqueue(new Callback<Trip>() {
                    @Override
                    public void onResponse(@NonNull Call<Trip> call, @NonNull Response<Trip> response) {
                        if (response.isSuccessful()) {
                            if (response.body().getPlan() != null) {
                                callback.showResult(response.body().getPlan());
                                dismiss();
                            } else if (response.body().getError() != null)
                                displaySnackBar(response.body().getError().getMsg());
                        } else
                            displaySnackBar("Error: " + String.valueOf(response.code()));
                    }

                    @Override
                    public void onFailure(Call<Trip> call, Throwable t) {
                        displaySnackBar(t.getMessage());
                        Log.d("onFailure: ", Arrays.toString(t.getStackTrace()));
                    }
                });
    }

    private String getPlaceParam(EditText latitude, EditText longitude) {
        return String.format("%s,%s", latitude.getText().toString(), longitude.getText().toString());
    }

    private OTPService getOtpService() {
        ApiClient apiClient = new ApiClient();
        return apiClient.getRetrofit().create(OTPService.class);
    }

    @NonNull
    private String getModeParams() {
        String mode = getCheckedModes();
        return mode.length() > 0 ? mode.substring(0, mode.length() - 1) : mode;
    }

    private String getCheckedModes() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ModeEnum modeEnum : ModeEnum.values()) {
            if (modeEnum.isChecked()) {
                stringBuilder.append(modeEnum.getTitle()).append(",");
            }
        }
        return stringBuilder.toString();
    }

    private void displaySnackBar(String text) {
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
    }
}
