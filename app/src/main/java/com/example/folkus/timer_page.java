package com.example.folkus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
//import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class timer_page extends AppCompatActivity {

    private Chronometer chronometer;
    private long time_studied;
    private boolean running;
    TextView endText;
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
        endText=findViewById(R.id.endMessage);
        View BackButton2 = (Button) findViewById(R.id.BackButton2);
        BackButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToSetTimerActivity();
            }
        });

        chronometer.setText("00:00:00");
        TextView textView = (TextView) findViewById(R.id.targetTime);
        Intent intent = getIntent();
        Bundle packageFromCaller= intent.getBundleExtra("MyPackage");
        String timeString = packageFromCaller.getString(set_timer.EXTRA_MESSAGE);


        textView.setText(timeString+":00");

    }

    public void startChronometer(View v) {
        Button start_stop = findViewById(R.id.start_stop);
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            running = true;
            start_stop.setText("End Session");
            View BackButton2 = (Button) findViewById(R.id.BackButton2);
            BackButton2.setVisibility(View.GONE);
        } else {
            chronometer.stop();
            time_studied = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
            endText.setText("Congrats! You have studied for ");
            start_stop.setVisibility(View.GONE);
            View BackButton2 = (Button) findViewById(R.id.BackButton2);
            BackButton2.setVisibility(View.VISIBLE);

        }


    }

    private void moveToSetTimerActivity()
    {
        startActivity(new Intent(timer_page.this,MainActivity.class));
    }

}