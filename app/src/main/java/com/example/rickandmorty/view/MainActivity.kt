package com.example.rickandmorty.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lists.viewmodel.ListFragment
import com.example.rickandmorty.R


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