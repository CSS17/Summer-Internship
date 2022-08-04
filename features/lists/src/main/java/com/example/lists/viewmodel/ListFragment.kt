package com.example.lists.viewmodel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filter.FilterFragment
import com.example.lists.R
import com.example.lists.viewmodel.ListFragment.KEY.KEY_NAVIGATOR
import com.example.presentation.Adapter.Adapter
import com.example.presentation.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var viewModel: CharacterViewModel
    private lateinit var filterFragment: FilterFragment
    object KEY {
        const val KEY_NAVIGATOR = "NAVIGATOR"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        filterFragment= FilterFragment()

       /* val bundle = this.arguments
        if (bundle != null) {
            val navigator : ListNavigator = bundle.getSerializable(KEY_NAVIGATOR) as ListNavigator
            navigator.navigateFilter()
        }*/



    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val t=inflater.inflate(R.layout.fragment_list, container, false)
        val spinner = t.findViewById<Spinner>(R.id.sp_status)
        var list=resources.getStringArray(R.array.status)
        spinner.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,list)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                Log.d("LAMBDA","I HAVE BEEN SELECTED")
                when(position){
                    0-> getAll(parent.getItemAtPosition(position).toString())
                    1-> getAll(parent.getItemAtPosition(position).toString())
                    2->getAll(parent.getItemAtPosition(position).toString())
                    else->getAll(parent.getItemAtPosition(position).toString())

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                Log.d("DELTA","NOTHING SELECTED")

            }
        }
        return t
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MARS","I AM WORKING HUH?")



    }
    fun getAll(status:String){
        viewModel= CharacterViewModel()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getCharacters(status)

        }
        when(status){
            "ALL"->{
                viewModel.users.observe(this, Observer { characterList ->
                    Log.d("CHARACTER",characterList.results.toString())
                    recyclerview1.layoutManager = LinearLayoutManager(this.context)
                    recyclerview1.adapter = Adapter(characterList.results)


                })
            }
            "ALIVES"->{
                viewModel.users.observe(this, Observer { characterList ->
                    Log.d("CHARACTER",characterList.results.toString())
                    recyclerview1.layoutManager = LinearLayoutManager(this.context)
                    recyclerview1.adapter = Adapter(characterList.results)


                })
            }

            "DEADS"->{
                viewModel.users.observe(this, Observer { characterList ->
                    Log.d("CHARACTER",characterList.results.toString())
                    recyclerview1.layoutManager = LinearLayoutManager(this.context)
                    recyclerview1.adapter = Adapter(characterList.results)


                })
            }

            else->{
                viewModel.users.observe(this, Observer { characterList ->
                    Log.d("CHARACTER",characterList.results.toString())
                    recyclerview1.layoutManager = LinearLayoutManager(this.context)
                    recyclerview1.adapter = Adapter(characterList.results)


                })
            }
            }
    }



}