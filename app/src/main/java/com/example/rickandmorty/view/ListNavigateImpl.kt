package com.example.rickandmorty.view

import androidx.fragment.app.FragmentActivity
import com.example.filter.FilterFragment
import com.example.lists.ListNavigator
import com.example.rickandmorty.R
import java.io.Serializable

class ListNavigateImpl(
    private val activity: FragmentActivity
) : ListNavigator, Serializable {
    override fun navigateFilter() {
        activity.supportFragmentManager.beginTransaction()
            .addToBackStack("profile")
            .replace(R.id.frameLayout, FilterFragment::class.java, null)
            .commit()
    }
}

