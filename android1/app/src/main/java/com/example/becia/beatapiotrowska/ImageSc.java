package com.example.becia.beatapiotrowska;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageSc extends AppCompatActivity {

    ProgressDialog pd;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        img1 = (ImageView) findViewById(R.id.imageView);
        //Log.i("tag", "Drawable img1: " + img1.getDrawable());
        //img1.setImageResource();
        img1.setImageDrawable(img1.getDrawable());


        //img1.setImageDrawable(LoadImageFromWebOperations("https://placehold.it/3000?text=item14"));

        JsonTaskM jt = new JsonTaskM();
        jt.execute("https://placehold.it/3000?text=item14");
        Log.i("tag", "Drawable jt: " + jt.drawable);

        /*try{
            URL url = new URL("https://placehold.it/3000?text=item14");
            Drawable drawable2 = Drawable.createFromStream(url.openStream(), "something.png");
            Log.i("tag", "Drawable2: " + drawable2);
        } catch (IOException e) {
            Log.i("tag", "Drawable2 eIO: ");
        }*/






        //Drawable dr = LoadImage("https://placehold.it/3000?text=item14");
        //Log.i("tag", "Drawable dr: " + dr);



    }

    /*public void callBa()
    {
        Log.i("tag", "Drawable2: " + this.JsonTaskM.drawable);
        //img1.setImageDrawable(drawable);
    }*/






    private class JsonTaskM extends AsyncTask<String, String, String> {

        public Drawable drawable;

        public void callBa()
        {
            Log.i("tag", "Callba this.drawable: " + this.drawable);
            img1.setImageDrawable(drawable);
        }
 
        /*public Drawable LoadImage(String url) {
            try {
                InputStream is = (InputStream) new URL(url).getContent();
                Drawable d = Drawable.createFromStream(is, "src name");
                Log.i("tag", "Drawable: ");
                return d;
            } catch (Exception e) {
                Log.i("tag", "Drawable e: " + e.toString());
                return null;
            }
        }*/

        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("RetClass: ", "onPreExecute: ");

            pd = new ProgressDialog(ImageSc.this);
            pd.setMessage("Please wait");
            pd.setCancelable(false);
            pd.show();
        }

        protected String doInBackground(String... params) {

            Log.d("RetClass: ", "doInBackground: ");

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL("https://placehold.it/3000?text=item14");
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                /*drawable = Drawable.createFromStream(stream, "src name");
                Log.i("tag", "Drawable: ");*/

                //URL url = new URL("http://www.examples.com/something.png");

                drawable = Drawable.createFromStream(url.openStream(), "something.png");
                Log.i("tag", "Drawable2: " + drawable);
                //img1.setImageDrawable(drawable);


                return null;


            } catch (MalformedURLException e) {
                Log.i("tag", "Drawable e: ");
                e.printStackTrace();
            } catch (IOException e) {
                Log.i("tag", "Drawable e: " + e.toString());
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
                    Log.i("tag", "Drawable e!!!!!: " + e.toString());
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

            callBa();


            /*Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();*/
            //Log.d("RetClass", "result: " + result);
            //txtJson.setText(result);

            /*Gson gson = new Gson();
            String jsonInString = result;

            Log.d("RetClass", "result: " + result);*/

            //User user = gson.fromJson(jsonInString, User.class);
            //Log.d("RetClass", "user: " + user.url);


            //Data data = gson.fromJson(jsonInString, Data.class);
            //List<User> array = data.array;

            //Log.d("RetClass", "data.array: " + data.array.get(1).desc);
            //Log.d("RetClass", "array: " + array.get(2).url);
        }
    }


        /*public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            Log.i("tag", "Drawable: ");
            return d;
        } catch (Exception e) {
            Log.i("tag", "Drawable e: " + e.toString());
            return null;
        }
    }*/
}
