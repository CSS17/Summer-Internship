package com.example.data.repository

import com.example.data.network.service.*
import com.example.rickandmorty.models.Character

class MainRepository {
    companion object{
        suspend fun getAllCharacters():Character{
            return RetrofitInstance.retrofitInstance.getCharacterData()
        }
        suspend fun getAliveCharacters():Character{
            return RetrofitInstance.retrofitInstance.getAliveCharacterData()
        }
        suspend fun getDeadCharacters():Character{
            return RetrofitInstance.retrofitInstance.getDeadCharacterData()
        }
        suspend fun getUnknownCharacters():Character{
            return RetrofitInstance.retrofitInstance.getUnknownCharacterData()
        }

    }



}