/*package com.example.becia.beatapiotrowska

import android.arch.lifecycle.LiveData
import com.example.becia.beatapiotrowska.HomeScreen.BASE_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.RetrofitClass
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class Photo {

    data class Photo(
            val url: String,
            val title: String,
            val desc: String
            )

    interface PhotosService {
        @GET("photos")
        fun listPhotos(): Call<List<Photo>>
    }

    val photosService = RetrofitClass.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhotosService::class.java)

    //var service = retrofit.create(Service::class.java)

    fun getNews(code: String): LiveData<List<Photo>> {

        photosService.listPhotos().enqueue(
                object : Callback<List<Photo>> {
                    override fun onFailure(call: Call<List<Photo>>,
                                           t: Throwable) {
                    }

                    override fun onResponse(call: Call<List<Photo>>,
                                            response: Response<List<Photo>>) {
                    }
                })
        return Photo
    }

    /*WebAPIService service1 = retrofit1.create(WebAPIService.class);
    Call<JsonObject> jsonCall = service1.readJson();
    jsonCall.enqueue(new Callback<JsonObject>() {
        @Override
        //public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
            //Log.i("LOG_TAG", response.body().toString());
        }*/

}*/