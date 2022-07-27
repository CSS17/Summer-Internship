package com.example.data.network.service

import com.example.data.network.utils.Constants
import com.example.rickandmorty.models.Character
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Retrofit_dead {
    @GET("api/character/?status=dead")
    suspend fun getDeads(): Character
    companion object {
        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()

        val retrofitInstance: Retrofit_dead by lazy {
            retrofit.create(Retrofit_dead::class.java)
        }
    }
}