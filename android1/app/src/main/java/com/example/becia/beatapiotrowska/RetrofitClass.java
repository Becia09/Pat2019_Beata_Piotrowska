package com.example.becia.beatapiotrowska;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RetrofitClass extends AppCompatActivity {

    //Button btnHit;
    //TextView txtJson;
    ProgressDialog pd;

    public final static String BASE_SERVER_URL = "http://192.168.56.1:8080/page_0.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //new JsonTask().execute(/*"http://10.0.2.2:8080/page_0.json/"*/);

    }


    /*private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("RetClass: ", "onPreExecute: ");

            pd = new ProgressDialog(RetrofitClass.this);
            pd.setMessage("Please wait");
            pd.setCancelable(false);
            pd.show();
        }

        protected String doInBackground(String... params) {

            Log.d("RetClass: ", "doInBackground: ");

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL("http://192.168.56.1:8080/page_0.json");
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                    //Log.d("RetClass: ", "Line: " + line);

                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.d("RetClass: ", "onPostExecute: ");
            if (pd.isShowing()){
                pd.dismiss();
            }

            /*Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();*/
            //Log.d("RetClass", "result: " + result);
            //txtJson.setText(result);
/*
            Gson gson = new Gson();
            String jsonInString = result;
            //User user = gson.fromJson(jsonInString, User.class);
            //Log.d("RetClass", "user: " + user.url);


            Data data = gson.fromJson(jsonInString, Data.class);
            List<User> array = data.array;

            Log.d("RetClass", "data.array: " + data.array.get(1).desc);
            Log.d("RetClass", "array: " + array.get(2).url);
        }
    }*/
}