package com.example.lists

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.lists.ListFragment.KEY.KEY_NAVIGATOR


class ListFragment : Fragment(R.layout.fragment_list) {

    object KEY {
        const val KEY_NAVIGATOR = "NAVIGATOR"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this.arguments
        if (bundle != null) {
            val navigator : ListNavigator = bundle.getSerializable(KEY_NAVIGATOR) as ListNavigator
            navigator.navigateFilter()
        }
    }

}