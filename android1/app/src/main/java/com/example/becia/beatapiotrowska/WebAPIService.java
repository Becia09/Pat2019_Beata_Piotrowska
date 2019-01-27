package com.example.becia.beatapiotrowska;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.lang.reflect.Array;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebAPIService {
    @GET("/")
    Call<JsonObject> readJson();//setLenient(true);
    }