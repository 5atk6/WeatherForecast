package com.example.atk.weatherforecasts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv_main);

        try {
            String data = WeatherApi.getWeather(this, "40040");
            textView.setText(data);
        } catch (IOException e) {
            Toast.makeText(this, "IOException is occurred",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
