package com.example.becia.beatapiotrowska;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.OutputStreamWriter;

public class FileSession extends AppCompatActivity {

    private static FileSession instance = null;


    private String path = Environment.getExternalStorageDirectory().toString() + "/loged.txt"; //+ "/"; //"/ifLoged/";

    private String interlude = "\n\n\n/////-----/////-----/////\n\n\n";



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

    public void createFile(){
        File file = new File(path); // + "/" + /*System.currentTimeMillis() +*/ "loged.txt");
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
            //Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
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

    public String getAllContent(){
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
                //deleteFile(path + paths[i]);
                //Log.e("Delete", "paths[i]: " + paths[i]);
            }
            return sb.toString();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            return "";
        }

    }

    public boolean deleteFileLoged(){
        System.out.println(path);
        try{
            File file = new File(path);//, "loged.txt");
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
    }




    private final int MEMORY_ACCES = 5;

    /*@Override
    public void onRequestPermissionsResult(int requestCode, String[] permission, int[] grantResult){
        switch (requestCode){
            case MEMORY_ACCES:
                if(grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) { //jeżeli pozwolenie zostało udzielone

                }
                else {
                    Toast.makeText(getApplicationContext(), "Jeśli nie zostanie wyrażona zgoda na dostęp do pamięci plik nie będzi zapisany", Toast.LENGTH_LONG).show();
                }
        }
    }*/


    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ActivityCompat.shouldShowRequestPermissionRationale(FileSession.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
        } else {
            ActivityCompat.requestPermissions(FileSession.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MEMORY_ACCES);
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }*/

}
