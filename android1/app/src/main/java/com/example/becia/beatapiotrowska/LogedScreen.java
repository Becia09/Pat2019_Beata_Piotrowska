package com.example.becia.beatapiotrowska;
//--------------------------------------------------------------------pozmieniać nazwy intentów

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class LogedScreen extends AppCompatActivity {

    /*private String path = Environment.getExternalStorageDirectory().toString() + "/";//"/ifLoged/";

    private String interlude = "\n\n\n/////-----/////-----/////\n\n\n";*/
    private TextView content;

    /*public boolean deleteFile(){
        String fullPath = path;
        System.out.println(fullPath);
        try{
            File file = new File(fullPath, "loged.txt");
            if(file.exists()){
                boolean result = file.delete();
                System.out.println("Application able to delete the file and result is: " + result);
                Log.e("Delete", "Plik skasowany z rezultatem: " + result);
                // file.delete();
                return true;
            }else{
                Log.e("Delete", "Pliku nie ma");
                System.out.println("Pliku nie ma");
            }
        }catch (Exception e){
            Log.e("Delete", "Exception while deleting file " + e.getMessage());
        }
        return false;
    }*/

    /*private String getAllContent(){
        try{
            File file = new File(path);
            String[] paths = file.list(new FilenameFilter() {    //filtr do szukania plików (np. po rozszerzeniu .txt)
                @Override
                public boolean accept(File dir, String fileName) {
                    return fileName.endsWith(".txt");
                }
            });
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < paths.length; i++)
            {
                sb.append(Files.toString(new File(path + paths[i]), Charsets.UTF_8));
                sb.append(interlude);
                deleteFile(path + paths[i]);
                Log.e("Delete", "paths[i]: " + paths[i]);
            }
            return sb.toString();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            return "";
        }

    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loged_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //deleteFile();
        //content = (TextView) findViewById(R.id.textView1);
        //content.setText(FileSession.getInstance().getAllContent());
        //Log.i("tag", "Funkcja: " + content);



        Button buttonLogOut = (Button)findViewById(R.id.logOut);  //przycisk wyloguj
        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileSession.getInstance().deleteFileLoged();

                Intent intentlogOut;
                intentlogOut = new Intent(LogedScreen.this, MainScreen.class);
                startActivity(intentlogOut);
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intentLogIn;
        intentLogIn = new Intent(LogedScreen.this, HomeScreen.class);
        startActivity(intentLogIn);
    }

}