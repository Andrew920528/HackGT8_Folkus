package com.example.folkus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.Toast;

import java.time.Clock;

public class set_timer extends AppCompatActivity {

    public Chronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_timer);

        EditText SetTimer = (EditText) findViewById(R.id.SetTimer);
        View NextButton = (Button) findViewById(R.id.NextButton);

        NextButton.setVisibility(View.INVISIBLE);

        String time1 = SetTimer.getText().toString();

        String timeList[] = time1.split(":");
        if (time1.matches("")) {
            Toast.makeText(this, "You did not enter a valid Time", Toast.LENGTH_SHORT).show();
            Log.d(time1, "is empty");
        }
        else
            {
            try
                {
                    int x= Integer.parseInt(timeList[0]);
                    int y= Integer.parseInt(timeList[1]);
                    Log.d(time1, "is it here");
                    if(x >= 0 & y >0 & y < 60)
                        {
                            NextButton.setVisibility(View.VISIBLE);
                            Log.d(time1, "is valid");


                        }
                }
            catch (NumberFormatException e)
                {
                    Toast.makeText(this, "You did not enter a valid Time", Toast.LENGTH_SHORT).show();
                }
            }
        if (NextButton.getVisibility() == View.VISIBLE)
        {

            NextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    moveToTimerActivity();
                }
            });
        }


    }
    private void moveToTimerActivity()
    {
        startActivity(new Intent(this,timer_page.class));
    }



}