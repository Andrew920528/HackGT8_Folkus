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
import android.widget.TextView;
import android.widget.Toast;

import java.time.Clock;
import java.util.List;

public class set_timer extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.folkus.set_timer";
    public Chronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_timer);

        EditText SetTimer = (EditText) findViewById(R.id.SetTimer);
        View NextButton = (Button) findViewById(R.id.NextButton);

        NextButton.setVisibility(View.VISIBLE);

        View BackButton = (Button) findViewById(R.id.BackButton);

        Intent intent = getIntent();
        Bundle packageFromCaller= intent.getBundleExtra("MyPackage");
        String message = packageFromCaller.getString(MainActivity.EXTRA_MESSAGE);
        TextView classview = findViewById(R.id.classText);
        classview.setText(message);
        TextView suggestedTime = findViewById(R.id.suggestedTime);
        switch(message) {
            case "CS1301": suggestedTime.setText("Suggested time: 01:12:00");
                break;
            case "MATH1554": suggestedTime.setText("Suggested time: 01:36:00");
                break;
            case "ENGL1102": suggestedTime.setText("Suggested time: 01:32:00");
                break;
            case "CS1331": suggestedTime.setText("Suggested time: 01:20:00");
                break;
        }











        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String time1 = SetTimer.getText().toString();
                Intent intent = new Intent(getApplicationContext(),timer_page.class);
                Bundle bundle=new Bundle();
                bundle.putString(EXTRA_MESSAGE,time1);
                intent.putExtra("MyPackage", bundle);
                startActivity(intent);


                if (time1.matches("") || time1 == null) {

                    System.out.print("Type Something");

                }
                else
                {
                    try
                    {
                        String[] timeList = time1.split(":");
                        int hours= Integer.parseInt(timeList[0]);
                        int minutes= Integer.parseInt(timeList[1]);

                        if((hours == 0 & minutes == 0)){
                            System.out.print("not valid");
                        }
                        else if(hours < 24 & minutes < 60)
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
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToSelectActivity();
            }
        });



    }
    private void moveToTimerActivity()
    {
        startActivity(new Intent(this,timer_page.class));
    }
    private void moveToSelectActivity()
    {
        startActivity(new Intent(this,MainActivity.class));
    }





}