package com.example.quakedec;

import org.json.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

public class QueryUtils {
    private String jsonString;

    public List<EarthQuakeData> getList(String jsonString) {
        this.jsonString=jsonString;
        List<EarthQuakeData> myList = new ArrayList<>();

        try {
            JSONObject JSONRootObject = new JSONObject(jsonString);
            JSONArray JSONFeatureArray = JSONRootObject.getJSONArray("features");
            for (int i = 0; i < JSONFeatureArray.length(); ++i) {
                JSONObject jsonObject = JSONFeatureArray.getJSONObject(i);
                JSONObject propertyObject = jsonObject.getJSONObject("properties");
                String place = propertyObject.getString("place");
                Double magnitude = propertyObject.getDouble("mag");
                long time = propertyObject.getLong("time");
                myList.add(new EarthQuakeData(magnitude, place, time));
            }
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
        return myList;
    }

    public JSONArray getRoot() throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject.getJSONArray("features");
    }

}
