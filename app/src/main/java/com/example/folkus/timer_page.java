package com.example.folkus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
//import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import com.example.folkus.set_timer;
public class timer_page extends AppCompatActivity {
    private Chronometer chronometer;
    private long time_studied;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_page);
        chronometer = findViewById(R.id.chronometer);
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                int h = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                int s = (int)(time - h*3600000- m*60000)/1000 ;
                String t = (h < 10 ? "0"+h: h)+":"+(m < 10 ? "0"+m: m)+":"+ (s < 10 ? "0"+s: s);
                chronometer.setText(t);
            }
        });
        chronometer.setText("00:00:00");

        TextView textView = (TextView) findViewById(R.id.targetTime);
        textView.setText("your target time");
    }

    public void startChronometer(View v) {
        Button start_stop = findViewById(R.id.start_stop);
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            running = true;
            start_stop.setText("End Session");
        } else {
            chronometer.stop();
            time_studied = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
            start_stop.setVisibility(View.GONE);
        }
    }

}