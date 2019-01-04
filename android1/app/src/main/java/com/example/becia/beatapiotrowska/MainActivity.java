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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        this.handler = new android.os.Handler();
        this.handler.postDelayed(
                this.runnable = new Runnable() {
                    public void run() {
                        Log.i("tag", "This'll run 5000 milliseconds later");
                        Intent intent2;
                        intent2 = new Intent(MainActivity.this, MainScreen.class);
                        startActivity(intent2);
                    }
                },
                5000);
    }


    public void click(View view) {
        this.handler.removeCallbacks(this.runnable);
    }
}
