package com.example.lists.viewmodel

import android.os.Bundle
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

private lateinit var viewModel: CharacterViewModel

 class Fragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getData()
        }

        viewModel.users.observe(this, Observer { characterList ->

            recyclerview1.layoutManager = LinearLayoutManager(this.context)
            recyclerview1.adapter = Adapter(characterList.results)


        })



    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_, container, false)
    }


}