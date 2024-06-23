package com.example.quakedec;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EarthQuakeData {
    private final Double scale;
    private final String place;
    private final Long date;


    public String getScale() {
        return scale.toString();
    }

    public String getPlace() {
        return place;
    }

    public String getDate() {

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy HH:mm a");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.date);
        return dateFormatter.format(calendar.getTime());


    }

    public EarthQuakeData(Double scale, String place, Long date) {
        this.scale = scale;
        this.place = place;
        this.date = date;
    }

}
