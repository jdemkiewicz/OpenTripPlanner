package com.jdemkiewicz.opentripplanner;

/**
 * Created by j.demkiewicz on 29.09.2017.
 */

public enum ModeEnum {
    BUS("BUS"), TRAM("TRAM"), WALK("WALK");
    private String title;
    private boolean isChecked;

    ModeEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
