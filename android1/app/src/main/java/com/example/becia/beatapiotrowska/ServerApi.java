package com.example.becia.beatapiotrowska;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServerApi {

    @GET("/register/test")
    Call<User> createAccount(@Body User user);
}
