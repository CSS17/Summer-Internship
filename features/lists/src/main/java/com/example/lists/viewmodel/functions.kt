package com.example.lists.viewmodel

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.Adapter.Adapter
import com.example.presentation.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.fragment_.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private lateinit var viewModel: CharacterViewModel
private lateinit var fragment_a: Fragment_Alive
private lateinit var fragment_d: Fragment_Dead
object functions {

    fun show_alives(){
        fragment_a= Fragment_Alive()
        viewModel=CharacterViewModel()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getAliveCharacters()
        }
        viewModel.alive_characters.observe( fragment_a, Observer { characterList ->
            fragment_a.recyclerview1.layoutManager = LinearLayoutManager(fragment_a.context)
            fragment_a.recyclerview1.adapter = Adapter(characterList.results)

        })
    }
    fun show_deads(){
        fragment_d= Fragment_Dead()
        viewModel=CharacterViewModel()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getDeadCharacters()
        }
        viewModel.dead_characters.observe(fragment_d, Observer { characterList ->
            fragment_d.recyclerview1.layoutManager = LinearLayoutManager(fragment_d.context)
            fragment_d.recyclerview1.adapter = Adapter(characterList.results)

        })
    }
}