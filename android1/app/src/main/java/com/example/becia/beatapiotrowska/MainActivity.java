package com.example.becia.beatapiotrowska;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    public Runnable runnable;
    public Handler handler;
    public static boolean flag = false;
    public SharedPreferencesIfLogged spIfLogged;

    public void delayActivity() {
        if (false == flag){
            this.handler = new android.os.Handler();
            this.handler.postDelayed(
                    this.runnable = new Runnable() {
                        public void run() {
                            Intent intentMainScreen;
                            intentMainScreen = new Intent(MainActivity.this, LoginScreen.class);
                            startActivity(intentMainScreen);
                        }
                    },
                    500);
            flag = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try{
            spIfLogged = new SharedPreferencesIfLogged(this);
        }
        catch (ExceptionInInitializerError e) {
            spIfLogged = SharedPreferencesIfLogged.getInstance();
        }

        delayActivity();
    }


    @Override
    public void onBackPressed() {
        this.handler.removeCallbacks(this.runnable);
    }
}