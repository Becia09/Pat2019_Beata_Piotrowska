package com.example.becia.beatapiotrowska;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class RecycleView extends AppCompatActivity {

    private static final String TAG = "RecView";
    public final static String BASE_SERVER_URL = "http://192.168.56.1:8080/page_0.json";
    public ArrayList<String> mImageTitles = new ArrayList<>();
    public ArrayList<String> mImageDescs = new ArrayList<>();
    public ArrayList<String> mImageUrls = new ArrayList<>();

    Data jsonData = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        JsonTask jt = new JsonTask(this, BASE_SERVER_URL, this);
    }

    public void initRecyclerView(){
        Log.d("RecView", "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mImageTitles, mImageDescs, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
