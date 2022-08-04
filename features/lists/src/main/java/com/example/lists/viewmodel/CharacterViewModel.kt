package com.example.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repository.MainRepository
import com.example.rickandmorty.models.Character
import kotlinx.coroutines.launch
import kotlin.math.log

private const val TAG = "User View Model"
class CharacterViewModel: ViewModel(){

    private var _characters = MutableLiveData<Character>()
    val users: LiveData<Character>
        get() = _characters

    fun getCharacters(status:String){
        viewModelScope.launch {
            try {
                when(status){
                    "ALL"->_characters.value = MainRepository.getAllCharacters()
                    "ALIVES"->_characters.value = MainRepository.getAliveCharacters()
                    "DEADS"->_characters.value = MainRepository.getDeadCharacters()
                    else->_characters.value = MainRepository.getUnknownCharacters()

                }



            }
            catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        }
    }




}