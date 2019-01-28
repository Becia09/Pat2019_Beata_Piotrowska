package com.example.becia.beatapiotrowska; //w callba wywoływać funkcję klasy RecycleView pobierającą elementy

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
//w klasie pobierającej elementy stworzyć obiekt JsonTask i w jego parametrze przekazywać zmienną do uzupełnienia danymi
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonTask extends AsyncTask<String, String, String> {

    private ProgressDialog pd;
    public static String BASE_SERVER_URL;// = "http://192.168.56.1:8080/page_0.json";
    Context context;

    //public User u = new User();
    public Data data;// = new Data();
    RecycleView mRecycleView;

    public Data callBa()
    {

        return data;
    }

    public JsonTask(Context contextActivity, String url, RecycleView recycleView, Data dataRecView)
    {
        this.context = contextActivity;
        this.BASE_SERVER_URL = url;
        this.mRecycleView = recycleView;

        /*u.url = "fdsf";
        dataRecView.array = new ArrayList<User>();
        dataRecView.array.add(u);*/

        //data.array = new ArrayList<User>();
        //data.array.add(u);
        //data.array.get(0).desc = "jeszcze nie ma";
        //Log.d("RetClass", "data.array: " + this.data.array.get(1).desc);
        this.execute(BASE_SERVER_URL);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("RetClass: ", "onPreExecute: ");

        /*pd = new ProgressDialog(context);
        pd.setMessage("Please wait");
        pd.setCancelable(false);
        pd.show();*/
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
        /*if (pd.isShowing()) {
            pd.dismiss();
        }*/

            /*Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();*/
        //Log.d("RetClass", "result: " + result);
        //txtJson.setText(result);

        Gson gson = new Gson();
        String jsonInString = result;
        //User user = gson.fromJson(jsonInString, User.class);
        //Log.d("RetClass", "user: " + user.url);


        /*Data*/ data = gson.fromJson(jsonInString, Data.class);
        //List<User> array = data.array;

        Log.d("RetClass", "data.array: " + data.array.get(0).desc);
        //Log.d("RetClass", "array: " + array.get(2).url);

        mRecycleView.jsonData = data;
        //mRecycleView.initImageBitmaps();

        for (int i = 0; i < data.array.size(); i++){
            mRecycleView.mImageTitles.add(data.array.get(i).title);
            mRecycleView.mImageUrls.add(data.array.get(i).url);
            mRecycleView.mImageDescs.add(data.array.get(i).desc);
        }


        //mRecycleView.mImageTitles
        mRecycleView.initRecyclerView();

        callBa();
    }
}
