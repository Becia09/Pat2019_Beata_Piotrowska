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

        if (false == SharedPreferencesIfLogged.getInstance().restoreData()){
            Intent intent2;
            intent2 = new Intent(LoggedScreen.this, LoginScreen.class);
            startActivity(intent2);
        }
        else {
            setContentView(R.layout.activity_logged_screen);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            Button buttonLogOut = (Button) findViewById(R.id.logOut);
            buttonLogOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferencesIfLogged.getInstance().saveData(false);
                    Intent intentlogOut;
                    intentlogOut = new Intent(LoggedScreen.this, LoginScreen.class);
                    startActivity(intentlogOut);
                }
            });

            Button buttoGoRecycler = (Button) findViewById(R.id.goRecycler);
            buttoGoRecycler.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    goRecycler();
                }
            });
        }
    }


    @Override
    public void onBackPressed() {
        goRecycler();
    }

    public void goRecycler(){
        Intent intentLogIn;
        intentLogIn = new Intent(LoggedScreen.this, RecycleView.class);
        startActivity(intentLogIn);
    }

}
