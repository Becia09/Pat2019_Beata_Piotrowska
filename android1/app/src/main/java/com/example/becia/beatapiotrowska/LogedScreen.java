package com.example.becia.beatapiotrowska;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LogedScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loged_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    /*Button buttonLogin = (Button)findViewById(R.id.login);  //przycisk wyloguj
        buttonLogin.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {

        }
    });*/

}
