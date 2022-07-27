package com.example.data.network.service

import android.provider.SyncStateContract
import com.example.rickandmorty.models.Character
import com.example.data.network.utils.Constants


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitApi {
    @GET("api/character?page=8")
    suspend fun getCharacterData():Character
    companion object {
        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()

        val retrofitInstance: RetrofitApi by lazy {
            retrofit.create(RetrofitApi::class.java)
        }
    }


}