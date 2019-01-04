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


        //Runnable r;
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
        //this.handler.removeCallbacks(this.runnable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void click(View view) {
        this.handler.removeCallbacks(this.runnable);
        /*Intent intent;
        intent = new Intent(MainActivity.this, MainScreen.class);
        startActivity(intent);*/
    }
}
