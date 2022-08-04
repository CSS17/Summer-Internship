package com.example.data.network.service

import com.example.data.network.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }
    val retrofitInstance: RetrofitApi by lazy {
        retrofit.create(RetrofitApi::class.java)
    }




    }
