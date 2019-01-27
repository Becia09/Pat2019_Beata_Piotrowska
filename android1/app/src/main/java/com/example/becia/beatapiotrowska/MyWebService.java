package com.example.becia.beatapiotrowska;

import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyWebService {
    @GET("/wsexample/") // deklarujemy endpoint oraz metodę
    void getData(Callback<DataBody> pResponse);

    /*@POST("/wsexample/") // deklarujemy endpoint, metodę oraz dane do wysłania
    void postData(@Body DataBody pBody, Callback<DataBody> pResponse);*/
}