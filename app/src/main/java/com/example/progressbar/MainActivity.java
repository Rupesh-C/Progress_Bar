package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar();


    }

    private void progressBar() {


        progressBar=findViewById(R.id.progessbar);
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                counter++;
                progressBar.setProgress(counter);
                if (counter==100) {
                    timer.cancel();

                    Intent intent = new Intent(getApplicationContext(),Jump.class);
                    startActivity(intent);

                }

            }
        };
        timer.schedule(timerTask,0,100);


    }


}