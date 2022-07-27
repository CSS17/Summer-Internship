package com.example.data.repository

import com.example.data.network.service.RetrofitApi
import com.example.data.network.service.Retrofit_alive
import com.example.data.network.service.Retrofit_dead
import com.example.data.network.service.Retrofit_unknown

class MainRepository constructor(private val retrofitService: RetrofitApi) {
    companion object {
        suspend fun getAllCharacters() = RetrofitApi.retrofitInstance.getCharacterData()
        suspend fun getAliveCharacters()=Retrofit_alive.retrofitInstance.getAlives()
        suspend fun getDeadCharacters()=Retrofit_dead.retrofitInstance.getDeads()
        suspend fun getUnknownCharacters()=Retrofit_unknown.retrofitInstance.getUnknowns()
    }
}