package com.example.becia.beatapiotrowska;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileSession extends AppCompatActivity {

    private static FileSession instance = null;
    private String path = Environment.getExternalStorageDirectory().toString() + "/loged.txt";


    FileSession() {
        if (null == instance){
            FileSession.instance = this;
        }
        else{
            throw new ExceptionInInitializerError("Instance class FileSession already exists");
        }
    }

    public static FileSession getInstance() {
        return FileSession.instance;
    }

    public void createFile(){
        File file = new File(path);
        FileOutputStream fOut;
        OutputStreamWriter myOutWriter;
        try {
            fOut = new FileOutputStream(file);
            myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append("strEmail");
            myOutWriter.close();
            fOut.close();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public boolean isLogged(){
        try{
            File file = new File(path);

            if (file.exists()){
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            return false;
        }
    }


    public boolean deleteFileLoged(){
        System.out.println(path);
        try{
            File file = new File(path);
            if(file.exists()){
                boolean result = file.delete();
                Log.e("Delete", "File delete with result: " + result);
                return true;
            }else{
                Log.e("Delete", "File not exists");
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            Log.e("Delete", "Exception while deleting file " + e.getMessage());
        }
        return false;
    }
}
