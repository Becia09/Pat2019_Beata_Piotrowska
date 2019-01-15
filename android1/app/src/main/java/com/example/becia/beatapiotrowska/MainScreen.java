package com.example.becia.beatapiotrowska;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText textEmail = (EditText) findViewById(R.id.email);
        EditText textPassword = (EditText) findViewById(R.id.password);


        Button buttonLogin = (Button)findViewById(R.id.login);  //przycisk logowania
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3;
                intent3 = new Intent(MainScreen.this, MainActivity.class);
                startActivity(intent3);
            }
        });

    }

}
