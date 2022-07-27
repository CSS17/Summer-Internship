package com.example.data.network.service

import com.example.data.network.utils.Constants
import com.example.rickandmorty.models.Character
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Retrofit_alive {
    @GET("api/character/?status=alive")
    suspend fun getAlives(): Character
    companion object {
        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()

        val retrofitInstance: Retrofit_alive by lazy {
            retrofit.create(Retrofit_alive::class.java)
        }
    }
}