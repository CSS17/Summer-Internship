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

    @GET("api/character/?status=alive")
    suspend fun getAliveCharacterData():Character

    @GET("api/character/?status=dead")
    suspend fun getDeadCharacterData():Character

     @GET("api/character/?status=unknown")
    suspend fun getUnknownCharacterData():Character


}
