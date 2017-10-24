package com.example.atk.weatherforecasts;

import android.location.Location;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * Created by atk on 2017/10/23.
 */
public class WeatherForecast {

    public final Location location;
    public final List<Forecast> forecastList = new ArrayList<Forecast>();

    public WeatherForecast(JSONObject jsonObject) throws JSONException {

        JSONObject locationObject = jsonObject.getJSONObject("location");
        location = new Location(locationObject);

        JSONArray forecastArray = jsonObject.getJSONArray("forecasts");

        int len = forecastArray.length();
        for (int i = 0; i < len; i++) {
            JSONObject forecastJson = forecastArray.getJSONObject(i);
            Forecast forecast = new Forecast(forecastJson);
            forecastList.add(forecast);
        }
    }

    public class Location {
        public final String area;
        public final String prefecture;
        public final String city;

        public Location(JSONObject jsonObject) throws JSONException {
            area = jsonObject.getString("area");
            prefecture = jsonObject.getString("prefecture");
            city = jsonObject.getString("city");
        }
    }
}
