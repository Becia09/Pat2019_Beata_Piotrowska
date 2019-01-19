package com.example.becia.beatapiotrowska;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LoggedScreen extends AppCompatActivity {

    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loged_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button buttonLogOut = (Button)findViewById(R.id.logOut);
        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileSession.getInstance().deleteFileLoged();

                Intent intentlogOut;
                intentlogOut = new Intent(LoggedScreen.this, MainScreen.class);
                startActivity(intentlogOut);
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intentLogIn;
        intentLogIn = new Intent(LoggedScreen.this, HomeScreen.class);
        startActivity(intentLogIn);
    }

}