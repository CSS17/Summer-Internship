package com.example.rickandmorty.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filter.FilterFragment
import com.example.lists.ListFragment
import com.example.rickandmorty.R
import com.example.presentation.viewmodel.CharacterViewModel
import java.util.logging.Filter


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigator = ListNavigateImpl(this)

        val bundle = Bundle()
        bundle.putSerializable(ListFragment.KEY.KEY_NAVIGATOR,navigator )

        val fragment = ListFragment()
        fragment.arguments = bundle


        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

}