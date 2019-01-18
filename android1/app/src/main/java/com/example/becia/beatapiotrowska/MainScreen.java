package com.example.becia.beatapiotrowska; //-------------------------------dodać regexy do stringów

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
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

    public TextView incorrectEmail;
    public TextView incorrectPassword;


    private String path = Environment.getExternalStorageDirectory().toString() + "/"; //"/ifLoged/";
    private final int MEMORY_ACCES = 5;

    //FileSession fs;

    //File file;

    /*public void createDir(){
        File folder = new File(path);
        if (!folder.exists()){
            try{
                folder.mkdir();
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }*/



    /*public void createFile(){
        file = new File(path + "/" + /*System.currentTimeMillis() +*//* "loged.txt");
        FileOutputStream fOut;
        OutputStreamWriter myOutWriter;
        try {
            fOut = new FileOutputStream(file);
            myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(strEmail);
            myOutWriter.close();
            fOut.close();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }*/


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
    public void onRequestPermissionsResult(int requestCode, String[] permission, int[] grantResult){
        switch (requestCode){
            case MEMORY_ACCES:
                if(grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) { //jeżeli pozwolenie zostało udzielone

                }
                else {
                    Toast.makeText(getApplicationContext(), "Jeśli nie zostanie wyrażona zgoda na dostęp do pamięci plik nie będzi zapisany", Toast.LENGTH_LONG).show();
                }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i("tag", "Funkcja onCreate, MainScreen - ekran logowania");


        if (ActivityCompat.shouldShowRequestPermissionRationale(MainScreen.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {}
        else {
            ActivityCompat.requestPermissions(MainScreen.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MEMORY_ACCES);
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);


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

                incorrectEmail = (TextView) findViewById(R.id.incorrectEmail);
                incorrectPassword = (TextView) findViewById(R.id.incorrectPassword);
                incorrectEmail.setText("");
                incorrectPassword.setText("");
                /*if (false == matcherEmail.matches()){
                    Log.i("tag", "email niepoprawny");
                    incorrectEmail.setText("Email niepoprawny");
                }

                if (false == matcherPassword.matches()){
                    Log.i("tag", "hasło niepoprawne");
                    incorrectPassword.setText("Hasło niepoprawne");
                }

                if(matcherEmail.matches() && matcherPassword.matches()){*/


                    /*try{
                        fs = new FileSession();
                    }
                    catch (ExceptionInInitializerError e) {
                        fs = FileSession.getInstance();
                    }*/


                    FileSession.getInstance().createFile();

                    Intent intentLogin;
                    intentLogin = new Intent(MainScreen.this, LogedScreen.class);
                    startActivity(intentLogin);



                    //createDir();

                //}
            }
        });

    }


    @Override
    protected void onPause(){
        Log.i("tag", "Funkcja onPause, MainScreen - ekran logowania");
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intentLogIn;
        intentLogIn = new Intent(MainScreen.this, MainActivity.class);
        startActivity(intentLogIn);
    }

}
