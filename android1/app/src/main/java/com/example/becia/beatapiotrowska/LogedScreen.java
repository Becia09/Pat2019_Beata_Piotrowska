package com.example.becia.beatapiotrowska;
//--------------------------------------------------------------------pozmieniać nazwy intentów

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LogedScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loged_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Button buttonLogin = (Button)findViewById(R.id.logOut);  //przycisk wyloguj
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentlogOut;
                intentlogOut = new Intent(LogedScreen.this, MainScreen.class);
                startActivity(intentlogOut);
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intentLogIn;
        intentLogIn = new Intent(LogedScreen.this, HomeScreen.class);
        startActivity(intentLogIn);
    }

}
