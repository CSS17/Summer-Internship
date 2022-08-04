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

   private var _alive_characters = MutableLiveData<Character>()
    val alive_characters: LiveData<Character>
        get() = _alive_characters

    private var _dead_characters = MutableLiveData<Character>()
    val dead_characters: LiveData<Character>
        get() = _dead_characters

    private var _unknown_characters = MutableLiveData<Character>()
    val unknown_characters: LiveData<Character>
        get() = _unknown_characters

    fun getData() {
        viewModelScope.launch {
            try {
                _characters.value = MainRepository.getAllCharacters()
                Log.d("ANOTHER",_characters.value.toString())
            }
            catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        }
    }

    fun getAliveCharacters(){
        viewModelScope.launch {
            try {
                _alive_characters.value = MainRepository.getAliveCharacters()
                Log.d("STATE",_alive_characters.value.toString())
            }
            catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        }
    }

    fun getDeadCharacters(){
        viewModelScope.launch {
            try {
                _dead_characters.value = MainRepository.getDeadCharacters()
            }
            catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        }
    }

    fun getUnknownCharacters(){
        viewModelScope.launch {
            try {
                _unknown_characters.value = MainRepository.getUnknownCharacters()
            }
            catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        }
    }


}