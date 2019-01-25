package com.example.becia.beatapiotrowska;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.view.View;

public class Validator /*extends AppCompatActivity*/ {

    private Pattern compiledPatternEmail;
    private Pattern compiledPatternPassword;

    private Matcher matcherEmail;
    private Matcher matcherPassword;

    private EditText textEmail;
    private String strEmail = "";

    private EditText textPassword;
    private String strPassword = "";

    private TextView incorrectEmail;
    private TextView incorrectPassword;


    public Activity activity;

    public Validator(Activity _activity){

        this.activity = _activity;
    }


    public boolean emailValidator()
    {
        compiledPatternEmail = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");

        textEmail = (EditText) this.activity.findViewById(R.id.email);
        strEmail = textEmail.getText().toString();
        matcherEmail = compiledPatternEmail.matcher(strEmail);
        incorrectEmail = (TextView) this.activity.findViewById(R.id.incorrectEmail);
        incorrectEmail.setText("");

        if (false == matcherEmail.matches()){
            incorrectEmail.setText("Email niepoprawny");
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean passwordValidator()
    {
        compiledPatternPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");

        textPassword = (EditText) this.activity.findViewById(R.id.password);
        strPassword = textPassword.getText().toString();
        matcherPassword = compiledPatternPassword.matcher(strPassword);
        incorrectPassword = (TextView) this.activity.findViewById(R.id.incorrectPassword);
        incorrectPassword.setText("");

        if (false == matcherPassword.matches()) {
            incorrectPassword.setText("Hasło niepoprawne");
            return false;
        }
        else
        {
            return true;
        }
    }
}
