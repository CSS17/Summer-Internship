package com.example.rickandmorty.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lists.ListFragment
import com.example.rickandmorty.R
import com.example.presentation.viewmodel.CharacterViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, ListFragment())
        fragmentTransaction.commit()
    }

}