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
import java.util.List;

public class set_timer extends AppCompatActivity {

    public Chronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_timer);

        EditText SetTimer = (EditText) findViewById(R.id.SetTimer);
        View NextButton = (Button) findViewById(R.id.NextButton);

        NextButton.setVisibility(View.VISIBLE);






        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String time1 = SetTimer.getText().toString();



                if (time1.matches("")) {

                    System.out.print("Type Something");

                }
                else
                {
                    try
                    {
                        String[] timeList = time1.split(":");
                        int x= Integer.parseInt(timeList[0]);
                        int y= Integer.parseInt(timeList[1]);
                        Log.d(time1, "is it here");
                        if(x < 24 & y < 60)
                        {
                            moveToTimerActivity();

                        }
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.print("not valid");
                    }
                    catch (RuntimeException e)
                    {
                        System.out.print("not valid format");
                    }
                }

            }
        });



    }
    private void moveToTimerActivity()
    {
        startActivity(new Intent(this,timer_page.class));
    }




}