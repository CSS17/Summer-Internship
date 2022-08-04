package com.example.presentation.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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
    val txtName: TextView = itemView.findViewById(R.id.name)
    val txtLocation: TextView = itemView.findViewById(R.id.location)
    val txtStatus: TextView = itemView.findViewById(R.id.status)

    fun getCharacter():CharacterViewModel{
        return viewModel
    }


    fun bind(characteritem: Result) {
        txtName.text = characteritem.name
        profileLink.load(characteritem.image)
        txtLocation.text = characteritem.location.name
        txtStatus.text=characteritem.status
    }
}