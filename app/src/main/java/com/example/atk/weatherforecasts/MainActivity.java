package com.example.atk.weatherforecasts;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import android.os.Handler;
import android.content.Context;

public class MainActivity extends Activity {

    private TextView textView;

    private class GetWeatherForecastTask extends GetWeatherForecastApiTask {
        public GetWeatherForecastTask(Context context) {
            super(context);
        }

        @Override
        protected void onPostExecute(String data) {
            super.onPostExecute(data);

            if (data != null) {
                textView.setText(data);
            } else if(exception != null) {
                Toast.makeText(MainActivity.this,
                        exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv_main);

        new GetWeatherForecastTask(this).execute("40040");
    }
}
