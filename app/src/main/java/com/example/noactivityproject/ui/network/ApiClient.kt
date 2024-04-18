package com.example.noactivityproject.ui.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private var service: ApiService? = null
    private val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    fun initClient() {
        val httpClient: OkHttpClient.Builder
                = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        service = retrofit.create(ApiService::class.java)
    }

    fun getPicturesList(callback: (List<String>?) -> Unit) {
        service?.getDogPicturesList()?.enqueue(object : Callback<DogPictures> {
            override fun onResponse(call: Call<DogPictures>, response: Response<DogPictures>) {
                val list = response.body()?.message
                callback.invoke(list)
            }

            override fun onFailure(call: Call<DogPictures>, error: Throwable) {
                Log.e("ApiClient", "Cannot get dog picture list", error)
            }

        })
    }
}