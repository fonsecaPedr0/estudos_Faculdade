package com.example.screensplash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        Thread timeThread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent it = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(it);
                }
            }


        };
        timeThread.start();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        finish();
    }


}