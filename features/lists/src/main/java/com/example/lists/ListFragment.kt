package com.example.lists

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
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filter.FilterFragment
import com.example.lists.ListFragment.KEY.KEY_NAVIGATOR
import com.example.lists.viewmodel.FragmentList
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
        //viewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)
        /*val bundle = this.arguments
        if (bundle != null) {
            val navigator : ListNavigator = bundle.getSerializable(KEY_NAVIGATOR) as ListNavigator
            navigator.navigateFilter()
        }*/
        filterFragment= FilterFragment()
        viewModel= CharacterViewModel()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getData()

        }

        viewModel.users.observe(this, Observer { characterList ->
            Log.d("CHARACTER",characterList.results.toString())
            recyclerview1.layoutManager = LinearLayoutManager(this.context)
            recyclerview1.adapter = Adapter(characterList.results)


        })

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
                    0->{
                        Toast.makeText(requireContext(),"SELECTED ${parent.getItemAtPosition(position)}",Toast.LENGTH_LONG).show()
                        displayAllCharacters()
                    }
                    1->{
                        Toast.makeText(requireContext(),"SELECTED ${parent.getItemAtPosition(position)}",Toast.LENGTH_LONG).show()
                        displayAliveCharacters()
                    }
                    2->displayDeadCharacters()
                    else->displayUnkownCharacters()

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
    fun displayAllCharacters(){
        viewModel= CharacterViewModel()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getData()

        }

        viewModel.users.observe(this, Observer { characterList ->
            Log.d("CHARACTER",characterList.results.toString())
            recyclerview1.layoutManager = LinearLayoutManager(this.context)
            recyclerview1.adapter = Adapter(characterList.results)


        })

    }

 fun displayAliveCharacters(){
        viewModel= CharacterViewModel()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getAliveCharacters()

        }

        viewModel.alive_characters.observe(this, Observer { characterList ->
            Log.d("CHARACTER",characterList.results.toString())
            recyclerview1.layoutManager = LinearLayoutManager(this.context)
            recyclerview1.adapter = Adapter(characterList.results)


        })

    }

 fun displayDeadCharacters(){
        viewModel= CharacterViewModel()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getDeadCharacters()

        }

        viewModel.dead_characters.observe(this, Observer { characterList ->
            Log.d("CHARACTER",characterList.results.toString())
            recyclerview1.layoutManager = LinearLayoutManager(this.context)
            recyclerview1.adapter = Adapter(characterList.results)


        })

    }

 fun displayUnkownCharacters(){
        viewModel= CharacterViewModel()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getUnknownCharacters()

        }

        viewModel.unknown_characters.observe(this, Observer { characterList ->
            Log.d("CHARACTER",characterList.results.toString())
            recyclerview1.layoutManager = LinearLayoutManager(this.context)
            recyclerview1.adapter = Adapter(characterList.results)


        })

    }


}