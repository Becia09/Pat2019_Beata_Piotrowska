package com.example.becia.beatapiotrowska;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class RecycleView extends AppCompatActivity {

    private static final String TAG = "RecView";
    public final static String BASE_SERVER_URL = "http://192.168.56.1:8080/page_1.json";

    public ArrayList<String> mImageTitles = new ArrayList<>();
    public ArrayList<String> mImageDescs = new ArrayList<>();
    public ArrayList<String> mImageUrls = new ArrayList<>();

    Data jsonData = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        JsonTask jt = new JsonTask(this, BASE_SERVER_URL, this, jsonData);
        //jt.execute(BASE_SERVER_URL);
        //Log.d("RecView", "json: " + jsonData.array.get(0).url);



        //Log.d("RecView", "onCreate");

        //initImageBitmaps();
    }

    public void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");


        mImageUrls.add("https://placehold.it/3000?text=item14");
        mImageTitles.add("Havasu Falls");
        mImageDescs.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mImageTitles.add("Trondheim");
        mImageDescs.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mImageTitles.add("Portugal");
        mImageDescs.add("Havasu Falls");

        //mImageUrls.add(jsonData.array.get(0).url);
        //mImageTitles.add(jsonData.array.get(0).title);

        /*mImageUrls.add("drawable/owczunia.jpg");
        mImageTitles.add("Owca");*/

        initRecyclerView();
    }

    public void initRecyclerView(){
        Log.d("RecView", "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        //RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mImageTitles, mImageDescs, mImageUrls, this, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
