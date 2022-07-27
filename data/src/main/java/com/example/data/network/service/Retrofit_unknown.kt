package com.example.data.network.service

import com.example.data.network.utils.Constants
import com.example.rickandmorty.models.Character
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Retrofit_unknown {
    @GET("api/character/?status=unknown")
    suspend fun getUnknowns(): Character
    companion object {
        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()

        val retrofitInstance: Retrofit_unknown by lazy {
            retrofit.create(Retrofit_unknown::class.java)
        }
    }
}