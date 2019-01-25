package com.example.becia.beatapiotrowska; //login screen

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainScreen extends AppCompatActivity {

    private static final String PREFERENCES_NAME = "ifLogged";
    private static final String PREFERENCES_IF_LOGGED = "loggingIn";
    private SharedPreferences preferences;

    public Pattern compiledPatternEmail;
    public Pattern compiledPatternPassword;

    public Matcher matcherEmail;
    public Matcher matcherPassword;

    EditText textEmail;
    public String strEmail = "";

    EditText textPassword;
    public String strPassword = "";

    public TextView incorrectEmail;
    public TextView incorrectPassword;


    private String path = Environment.getExternalStorageDirectory().toString() + "/";
    private final int MEMORY_ACCES = 5;


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permission, int[] grantResult){
        switch (requestCode){
            case MEMORY_ACCES:
                if(grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) { //jeżeli pozwolenie zostało udzielone
                    Log.i("tag", "Zezwolony dostęp");
                }
                else {
                    Toast.makeText(getApplicationContext(), "Jeśli nie zostanie wyrażona zgoda na dostęp do pamięci plik nie będzi zapisany", Toast.LENGTH_LONG).show();
                }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //preferences = getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);

        /*if (FileSession.getInstance().isLogged()){
            Intent intent2;
            intent2 = new Intent(MainScreen.this, LoggedScreen.class);
            startActivity(intent2);}*/

        /*SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        boolean first = SharedPreferencesIfLogged.getInstance().getBoolean("firstrun", true);
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        boolean first = preferences.getBoolean("firstrun", true);*/

        if (SharedPreferencesIfLogged.getInstance().restoreData()){
            Intent intent2;
            intent2 = new Intent(MainScreen.this, LoggedScreen.class);
            startActivity(intent2);
            Log.i("tag", "Czy zalogowano: " + SharedPreferencesIfLogged.getInstance().restoreData());
        }
        else {
            setContentView(R.layout.activity_main_screen);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            if (ActivityCompat.shouldShowRequestPermissionRationale(MainScreen.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(MainScreen.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MEMORY_ACCES);
            }
            getSupportActionBar().setDisplayShowHomeEnabled(true);


            compiledPatternEmail = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");
            compiledPatternPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");


            Button buttonLogin = (Button) findViewById(R.id.login);
            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    textEmail = (EditText) findViewById(R.id.email);
                    strEmail = textEmail.getText().toString();
                    matcherEmail = compiledPatternEmail.matcher(strEmail);
                    incorrectEmail = (TextView) findViewById(R.id.incorrectEmail);
                    incorrectEmail.setText("");

                    textPassword = (EditText) findViewById(R.id.password);
                    strPassword = textPassword.getText().toString();
                    matcherPassword = compiledPatternPassword.matcher(strPassword);
                    incorrectPassword = (TextView) findViewById(R.id.incorrectPassword);
                    incorrectPassword.setText("");

                    /*if (false == matcherEmail.matches()){
                        incorrectEmail.setText("Email niepoprawny");
                    }

                    if (false == matcherPassword.matches()){
                        incorrectPassword.setText("Hasło niepoprawne");
                    }

                    if(matcherEmail.matches() && matcherPassword.matches()){*/


                        //FileSession.getInstance().createFile();

                        //saveData(true);
                        SharedPreferencesIfLogged.getInstance().saveData(true);

                        Intent intentLogin;
                        intentLogin = new Intent(MainScreen.this, LoggedScreen.class);
                        startActivity(intentLogin);

                        /*if(preferences.getBoolean(PREFERENCES_IF_LOGGED, false))
                        {
                            Log.i("tag", "Funkcja: restoreData");
                            Log.i("tag", "Funkcja: restoreData: " + preferences.getBoolean(PREFERENCES_IF_LOGGED, false));
                        }*/
                    //}
                }
            });
        }

    }

    private void saveData(boolean ifLoggin) {
        SharedPreferences.Editor preferencesEditor = preferences.edit();
        //String editTextData = "";
        preferencesEditor.putBoolean(PREFERENCES_IF_LOGGED, ifLoggin);
        preferencesEditor.commit();
        Log.i("tag", "Funkcja: saveData");
    }

    @Override
    public void onBackPressed() {
        return;
    }

}
