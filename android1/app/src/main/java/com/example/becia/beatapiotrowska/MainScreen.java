package com.example.becia.beatapiotrowska;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainScreen extends AppCompatActivity {

    public Pattern compiledPatternEmail;// = Pattern.compile("Marcin");
    public Pattern compiledPatternPassword;

    public Matcher matcherEmail;// = compiledPattern.matcher("Nazywam sie Marcin Pietraszek");
    public Matcher matcherPassword;

    EditText textEmail;
    public String strEmail = "";

    EditText textPassword;
    public String strPassword = "";

    /*public boolean patternCorrect(EditText text, String str, Pattern pattern, Matcher matcher) {

        text = (EditText) findViewById(R.id.email);
        str = text.getText().toString();
        matcher = pattern.matcher(str);

        if (matcher.matches()){
            return true;
        }
        else {
            return false;
        }

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i("tag", "Funkcja onCreate, MainScreen - ekran logowania");


        compiledPatternEmail = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");
        compiledPatternPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");//("[[a-z]+[A-Z]+[0-9]+]{8,}");


        Button buttonLogin = (Button)findViewById(R.id.login);  //przycisk logowania
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textEmail = (EditText) findViewById(R.id.email);
                strEmail = textEmail.getText().toString();

                textPassword = (EditText) findViewById(R.id.password);
                strPassword = textPassword.getText().toString();

                matcherEmail = compiledPatternEmail.matcher(strEmail);
                matcherPassword = compiledPatternPassword.matcher(strPassword);

                Log.i("tag", "strEmail: " + strEmail);
                Log.i("tag", "strPassword: " + strPassword);

                if (matcherEmail.matches() && matcherPassword.matches()){
                    Log.i("tag", "email i hasło poprawne");
                }
                else if (matcherEmail.matches()){
                    Log.i("tag", "email poprawny");
                }
                else if (matcherPassword.matches()){
                    Log.i("tag", "hasło poprawne");
                }
            }
        });

    }


    @Override
    protected void onPause(){
        Log.i("tag", "Funkcja onPause, MainScreen - ekran logowania");
        super.onPause();
    }

}
