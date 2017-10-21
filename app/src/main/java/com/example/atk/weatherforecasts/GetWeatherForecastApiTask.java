package com.example.atk.weatherforecasts;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
/**
 * Created by atk on 17/10/21.
 */
public class GetWeatherForecastApiTask extends AsyncTask<String, Void, String>{
    private final Context context;
    Exception exception;

    public GetWeatherForecastApiTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... paramas){
        try {
            return WeatherApi.getWeather(context, paramas[0]);
        } catch (IOException e) {
            exception = e;
        }
        return null;
    }
}
