package com.example.becia.beatapiotrowska;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator {

    public Activity activity;

    public Validator(Activity _activity){
        this.activity = _activity;
    }


    public boolean emailValidator()
    {
        Pattern compiledPatternEmail = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");
        EditText textEmail = (EditText) this.activity.findViewById(R.id.email);
        String strEmail = textEmail.getText().toString();
        Matcher matcherEmail = compiledPatternEmail.matcher(strEmail);
        TextView incorrectEmail = (TextView) this.activity.findViewById(R.id.incorrectEmail);
        incorrectEmail.setText("");

        if (! matcherEmail.matches()){
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
        Pattern compiledPatternPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");

        EditText textPassword = (EditText) this.activity.findViewById(R.id.password);
        String strPassword = textPassword.getText().toString();
        Matcher matcherPassword = compiledPatternPassword.matcher(strPassword);
        TextView incorrectPassword = (TextView) this.activity.findViewById(R.id.incorrectPassword);
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
