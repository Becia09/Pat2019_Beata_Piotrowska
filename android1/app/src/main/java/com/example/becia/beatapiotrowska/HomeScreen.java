package com.example.becia.beatapiotrowska;

import android.graphics.Bitmap;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLConnection;


import java.net.URL;
import java.io.InputStream;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public class HomeScreen extends AppCompatActivity {

    public URL url;
    public HttpURLConnection urlConnection;
    public static final String BASE_URL = "http://10.0.2.2:8080/page_0.json";


    // tag, który jest wykorzystany do logowania
    private static final String CLASS_TAG = "MainActivity";

    // adapter REST z Retrofita
    Retrofit retrofit;
    // nasz interfejs
    MyWebService myWebService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i("tag", "OnCreate HomeScreen");




//===============================================================
        /*RetrofitClass retrofit = RetrofilClient.getClient("http://10.0.2.2:8080/page_0.json/");
        //String json = retrofit.//getInfo().execute().body().string();
        Log.i("tag", "RetrofitClass: " + retrofit);

        WebAPIService api = retrofit.create(WebAPIService.class);

        try {
            Response<JsonObject> user = api.readJson().execute();//getJsonObject().execute();
        } catch (Exception e) {
            Log.i("tag", "Response exception");
        }*/

//======================================================================

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();



        Retrofit retrofit1 = new Retrofit.Builder()
                //.baseUrl("http://10.0.2.2:8080/page_1.json/")
                //.baseUrl("http://127.0.0.1:8080/page_0.json")//niedziała
                .baseUrl("http://192.168.56.1:8080/page_1.json")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        WebAPIService service1 = retrofit1.create(WebAPIService.class);
        Call<JsonObject> jsonCall = service1.readJson();
        jsonCall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.i("LOG_TAG", "onResponse: " + response.body().toString());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("LOG_TAG", "onFailure: " + t.toString());
            }
        });


//============================================================================


        /*RetrofitClass retrofit = new RetrofitClass.Builder()
                .baseUrl("http://10.0.2.2:8080/page_0.json")
                .addConverterFactory(GsonConverterFactory.create())
                .build();*/



        /*/==============================retrofit
        RetrofitClass retrofit = new RetrofitClass.Builder()
                .baseUrl(BASE_URL)
                //.addConverterFactory(GsonConverterFactory.create())
                .build();
        //Api api = retrofit.create(Api.class);
        Call<ResponseBody> call = api.checkLevel(1);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                JsonObject post = new JsonObject().get(response.body().toString()).getAsJsonObject();
                if (post.get("Level").getAsString().contains("Administrator")) {

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });*/

        //=========================================dokumentacja
        /*/URL url;
        try {
            //String u = "http://webapi.com/demo.zip";
            url = new URL("http://127.0.0.1:8080/page_0.json");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.i("tag", "Wyjątek MalformedURLException");
        }
        catch (Exception e) {
            e.printStackTrace();
            Log.i("tag", "Wyjątek");
        }
        //URL url = new URL("http://127.0.0.1:8080/page_0.json");

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException eIO) {
            eIO.printStackTrace();
            Log.i("tag", "Wyjątek IOException");
        }
        catch (Exception e) {
            e.printStackTrace();
            Log.i("tag", "Wyjątek");
        }
        //HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            readStream(in);
        } catch (Exception e) {
                e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }*/

        //---------------------------------------------------stack:
        //URL url;
        /*/HttpURLConnection urlConnection = null;
        InputStream in = null;
        Log.i("tag", "Przed try");
        try {
            url = new URL("http://10.0.2.2:8080/page_0.json");
            Log.i("tag", "try");
            urlConnection = (HttpURLConnection) url.openConnection();

            in = urlConnection.getInputStream();
            String result = null;

            //InputStreamReader isw = new InputStreamReader(in, "utf-8");

            //BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
//----------
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null)
                {
                    sb.append(line + "\n");
                }
                result = sb.toString();
                } catch (Exception e) {
                    Log.i("tag", "Exception: " + e.toString());
                }
                finally {
                try{
                    if(in != null)
                        in.close();
                }catch(Exception squish){
                    Log.i("tag", "Exception: " + squish.toString());
                }
            }*/


            /*StringBuilder sb = new StringBuilder();
            String line = null;
            Log.i("tag", "Przed while");
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
                Log.i("tag", "line: " + line);
            }
            Log.i("tag", "Line " + sb.toString());
        } catch (Exception e) {
            Log.i("tag", "Exception: " + e.toString());
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }*/

        /*DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());
        HttpPost httppost = new HttpPost("http://10.0.2.2:8080/page_0.json");
// Depends on your web service
        httppost.setHeader("Content-type", "application/json");

        InputStream inputStream = null;
        String result = null;
        try {
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            inputStream = entity.getContent();
            // json is UTF-8 by default
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            result = sb.toString();
        } catch (Exception e) {
            // Oops
        }
        finally {
            try{if(inputStream != null)inputStream.close();}catch(Exception squish){}
        }*/

        /*// ustawiamy wybrane parametry adaptera
        retrofit = new Retrofit.Builder()
                // adres API
                .baseUrl("http://10.0.2.2:8080/page_0.json/")
                // niech Retrofit loguje wszystko co robi
                //.setLogLevel(Retrofit.LogLevel.FULL)
                .build();


        // tworzymy klienta
        myWebService = retrofit.create(MyWebService.class);
        //Call<JsonObject> jsonCall = service1.readJson();
        //jsonCall.enqueue(new Callback<JsonObject>() {

            try {
                myWebService.getData(new Callback<DataBody>() {
                    @Override
                    public void success(DataBody myWebServiceResponse, Response response) {
                        Log.d(CLASS_TAG, myWebServiceResponse.getName());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d(CLASS_TAG, error.getLocalizedMessage());
                    }
                });

            } catch (Exception e) {
                Log.d(CLASS_TAG, e.toString());
            }*/

    }

}
