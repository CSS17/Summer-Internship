package com.example.rickandmorty.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lists.viewmodel.*
import com.example.rickandmorty.R
import com.example.presentation.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.activity_main.*
private lateinit var viewModel: CharacterViewModel
lateinit var object_for_btn: functions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeFragment(Fragment())
        object_for_btn = functions
        btn_alives.setOnClickListener {
            //object_for_btn.show_alives()
            change_to_alives(Fragment_Alive())

        }
        btn_deads.setOnClickListener {
            //object_for_btn.show_deads()
            change_to_deads(Fragment_Dead())
        }
        btn_unknowns.setOnClickListener {
            change_to_unknowns(Fragment_Unknown())
        }
    }
    fun changeFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
    fun change_to_alives(fragment: Fragment_Alive){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
    fun change_to_deads(fragment: Fragment_Dead){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
    fun change_to_unknowns(fragment: Fragment_Unknown){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

}