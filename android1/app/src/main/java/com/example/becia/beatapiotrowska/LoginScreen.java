package com.example.becia.beatapiotrowska; //login screen

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginScreen extends AppCompatActivity {

    private Validator instance = new Validator(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (SharedPreferencesIfLogged.getInstance().restoreData()){
            Intent intent2;
            intent2 = new Intent(LoginScreen.this, LoggedScreen.class);
            startActivity(intent2);
        }
        else {
            setContentView(R.layout.activity_login_screen);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            Button buttonLogin = (Button) findViewById(R.id.login);
            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean emailValid = instance.emailValidator();
                    boolean passwordValid = instance.passwordValidator();
                    if(emailValid && passwordValid){
                        SharedPreferencesIfLogged.getInstance().saveData(true);
                        Intent intentLogin;
                        intentLogin = new Intent(LoginScreen.this, LoggedScreen.class);
                        startActivity(intentLogin);
                        instance = null;
                    }
                }
            });
        }

    }

    @Override
    public void onBackPressed() {
        return;
    }

}
