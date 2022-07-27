package com.example.lists.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lists.R
import com.example.presentation.Adapter.Adapter
import com.example.presentation.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.fragment_.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private lateinit var viewModel_alive: CharacterViewModel
class Fragment_Alive : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel_alive= CharacterViewModel()
        viewModel_alive = ViewModelProviders.of(this).get(CharacterViewModel::class.java)

        CoroutineScope(Dispatchers.IO).launch {

            viewModel_alive.getAliveCharacters()

        }

        viewModel_alive.alive_characters.observe(this, Observer { aliveList ->
            Log.d("MARS",aliveList.results.toString())
            recyclerview1.layoutManager = LinearLayoutManager(this.context)
            recyclerview1.adapter = Adapter(aliveList.results)


        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__alive, container, false)
    }


}