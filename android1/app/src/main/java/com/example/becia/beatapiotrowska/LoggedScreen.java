package com.example.becia.beatapiotrowska; //zrobić blokadę wejścia do aktywnosci w przypadku niezalogowania

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.util.Log;
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
            intent2 = new Intent(LoggedScreen.this, MainScreen.class);
            startActivity(intent2);
            Log.i("tag", "Czy zalogowano: " + SharedPreferencesIfLogged.getInstance().restoreData());
        }
        else {
            setContentView(R.layout.activity_loged_screen);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            Button buttonLogOut = (Button) findViewById(R.id.logOut);
            buttonLogOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //FileSession.getInstance().deleteFileLoged();
                    SharedPreferencesIfLogged.getInstance().saveData(false);

                    Intent intentlogOut;
                    intentlogOut = new Intent(LoggedScreen.this, MainScreen.class);
                    startActivity(intentlogOut);
                }
            });
        }
    }


    @Override
    public void onBackPressed() {
        Intent intentLogIn;
        intentLogIn = new Intent(LoggedScreen.this, HomeScreen.class);
        startActivity(intentLogIn);
    }

}
