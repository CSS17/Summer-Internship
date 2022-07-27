package com.example.presentation.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.lists.R
import com.example.rickandmorty.models.Result
import com.example.presentation.viewmodel.CharacterViewModel
private lateinit var viewModel: CharacterViewModel

class ViewHolder (container: ViewGroup, layout: Int) : RecyclerView.ViewHolder(
    LayoutInflater.from(container.context).inflate
        (
        layout,
        container,
        false
    )
) {
    val profileLink: ImageView = itemView.findViewById(R.id.imgProfilePhoto)
    val txtname: TextView = itemView.findViewById(R.id.name)
    val txtlocation: TextView = itemView.findViewById(R.id.location)
    val txtstatus: TextView = itemView.findViewById(R.id.status)

    fun getCharacter():CharacterViewModel{
        return viewModel
    }


    fun bind(characteritem: Result) {
        txtname.text = characteritem.name
        profileLink.load(characteritem.image)
        txtlocation.text = characteritem.location.name
        txtstatus.text=characteritem.status
    }
}