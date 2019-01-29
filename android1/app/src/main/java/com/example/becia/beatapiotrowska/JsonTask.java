package com.example.becia.beatapiotrowska;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class JsonTask extends AsyncTask<String, String, String> {

    private ProgressDialog pd;
    public static String BASE_SERVER_URL;// = "http://192.168.56.1:8080/page_0.json";
    Context context;


    public Data data;
    RecycleView mRecycleView;
    public ArrayList<String> mImageTitlesJ = new ArrayList<>();
    public ArrayList<String> mImageDescJ = new ArrayList<>();
    public ArrayList<String> mImagesJ = new ArrayList<>();

    public Data callBa()
    {

        return data;
    }

    public JsonTask(Context contextActivity, String url, RecycleView recycleView)
    {
        this.context = contextActivity;
        this.BASE_SERVER_URL = url;
        this.mRecycleView = recycleView;

        this.execute(BASE_SERVER_URL);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("RetClass: ", "onPreExecute: ");

    }

    protected String doInBackground(String... params) {

        Log.d("RetClass: ", "doInBackground: ");

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(BASE_SERVER_URL);//"http://192.168.56.1:8080/page_0.json");
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
            Log.d("RetClass: ", "e.printStackTrace(): " + e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("RetClass: ", "e.printStackTrace(): " + e.toString());
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
                Log.d("RetClass: ", "e.printStackTrace(): " + e.toString());
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.d("RetClass: ", "onPostExecute: ");


        Gson gson = new Gson();
        String jsonInString = result;

        data = gson.fromJson(jsonInString, Data.class);

        Log.d("RetClass", "data.array: " + data.array.get(0).desc);

        mRecycleView.jsonData = data;


        for (int i = 0; i < data.array.size(); i++){
            mImageTitlesJ.add(data.array.get(i).title);
            mImagesJ.add(data.array.get(i).url);
            mImageDescJ.add(data.array.get(i).desc);
            //mRecycleView.mImageTitles.add(data.array.get(i).title);
            //mRecycleView.mImageUrls.add(data.array.get(i).url);
            //mRecycleView.mImageDescs.add(data.array.get(i).desc);
        }

        mRecycleView.mImageTitles = mImageTitlesJ;
        mRecycleView.mImageUrls = mImagesJ;
        mRecycleView.mImageDescs = mImageDescJ;


        mRecycleView.initRecyclerView();
    }
}
