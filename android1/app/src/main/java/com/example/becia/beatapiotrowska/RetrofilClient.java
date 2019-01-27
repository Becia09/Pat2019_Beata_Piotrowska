package com.example.becia.beatapiotrowska;

import android.util.Log;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofilClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    /*WebAPIService service1 = retrofit1.create(WebAPIService.class);
    Call<JsonObject> jsonCall = service1.readJson();
    jsonCall.enqueue(new Callback<JsonObject>() {
        @Override
        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            Log.i(LOG_TAG, response.body().toString());
        }

        @Override
        public void onFailure(Call<JsonObject> call, Throwable t) {
            Log.e(LOG_TAG, t.toString());
        }
    });*/
}
