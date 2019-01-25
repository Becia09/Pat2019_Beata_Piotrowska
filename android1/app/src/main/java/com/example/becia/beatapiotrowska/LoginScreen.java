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

    Validator instance = new Validator(this);

    /*public Pattern compiledPatternEmail;
    public Pattern compiledPatternPassword;

    /*public Matcher matcherEmail;
    public Matcher matcherPassword;

    EditText textEmail;
    public String strEmail = "";

    EditText textPassword;
    public String strPassword = "";

    public TextView incorrectEmail;
    public TextView incorrectPassword;*/


    //private String path = Environment.getExternalStorageDirectory().toString() + "/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //instance = new Validator(this);
        //preferences = getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);

        if (SharedPreferencesIfLogged.getInstance().restoreData()){
            Intent intent2;
            intent2 = new Intent(LoginScreen.this, LoggedScreen.class);
            startActivity(intent2);
            Log.i("tag", "Czy zalogowano: " + SharedPreferencesIfLogged.getInstance().restoreData());
        }
        else {
            setContentView(R.layout.activity_login_screen);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            /*compiledPatternEmail = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");
            compiledPatternPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");*/


            Button buttonLogin = (Button) findViewById(R.id.login);
            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    /*textEmail = (EditText) findViewById(R.id.email);
                    strEmail = textEmail.getText().toString();
                    matcherEmail = compiledPatternEmail.matcher(strEmail);
                    incorrectEmail = (TextView) findViewById(R.id.incorrectEmail);
                    incorrectEmail.setText("");

                    textPassword = (EditText) findViewById(R.id.password);
                    strPassword = textPassword.getText().toString();
                    matcherPassword = compiledPatternPassword.matcher(strPassword);
                    incorrectPassword = (TextView) findViewById(R.id.incorrectPassword);
                    incorrectPassword.setText("");*/

                    /*if (false == matcherEmail.matches()){
                        incorrectEmail.setText("Email niepoprawny");
                    }

                    if (false == matcherPassword.matches()){
                        incorrectPassword.setText("Hasło niepoprawne");
                    }

                    if(matcherEmail.matches() && matcherPassword.matches()){*/

                    boolean emailValid = instance.emailValidator();
                    boolean passwordValid = instance.passwordValidator();
                    if(emailValid && passwordValid){

                        SharedPreferencesIfLogged.getInstance().saveData(true);

                        Intent intentLogin;
                        intentLogin = new Intent(LoginScreen.this, LoggedScreen.class);
                        startActivity(intentLogin);

                        /*if(preferences.getBoolean(PREFERENCES_IF_LOGGED, false))
                        {
                            Log.i("tag", "Funkcja: restoreData");
                            Log.i("tag", "Funkcja: restoreData: " + preferences.getBoolean(PREFERENCES_IF_LOGGED, false));
                        }*/
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
