package com.example.becia.beatapiotrowska;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public Runnable runnable;
    public Handler handler;
    public static boolean flag = false;

    public FileSession fs;

    /*MainActivity()
    {
        super();
        /*try{
            fs = new FileSession();
        }
        catch (ExceptionInInitializerError e) {
            fs = FileSession.getInstance();
        }
    }*/

    public void delayActivity() {
        if (false == flag){
            this.handler = new android.os.Handler();
            this.handler.postDelayed(		//po 5 sekundach zmienia ekran/aktywność
                    this.runnable = new Runnable() {
                        public void run() {
                            //Log.i("tag", "This'll run 5000 milliseconds later");
                            Intent intent2;
                            intent2 = new Intent(MainActivity.this, MainScreen.class);
                            startActivity(intent2);
                        }
                    },
                    1000);
            flag = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i("tag", "Funkcja onCreate, MAinActivity - SplashScreen");

        try{
            fs = new FileSession();
        }
        catch (ExceptionInInitializerError e) {
            fs = FileSession.getInstance();
        }


        delayActivity();
    }


    /*public void click(View view) {
        this.handler.removeCallbacks(this.runnable); //anuluje działanie funcji postDelayed
    }*/

    @Override
    public void onBackPressed() {
        this.handler.removeCallbacks(this.runnable); //anuluje działanie funcji postDelayed z użyciem systemowego przycisku back

        if (flag) {
            super.onBackPressed();

            Intent intentLogIn;
            intentLogIn = new Intent(MainActivity.this, LogedScreen.class);
            startActivity(intentLogIn);
        }
    }


    @Override
    protected void onPause(){
        Log.i("tag", "Funkcja onPause, MAinActivity - SplashScreen");
        super.onPause();
    }
}