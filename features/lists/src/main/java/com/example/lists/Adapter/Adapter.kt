package com.example.presentation.Adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lists.Adapter.status_number
import com.example.lists.R
import com.example.rickandmorty.models.Result
import com.example.lists.Adapter.status_type
class Adapter(val CharacterList: List<Result>):RecyclerView.Adapter<ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        //var get_selection=status_selection.get_status(CharacterList[position].toString())
        when(CharacterList[position].status){
            status_type.DEAD.status_type-> return status_number.DEAD.number
            status_type.ALIVE.status_type-> return status_number.ALIVE.number
            else-> return status_number.UNKNOWN.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = if(viewType == status_number.DEAD.number) R.layout.dead
        else if(viewType == status_number.ALIVE.number) R.layout.alive
        else R.layout.unknown
        return ViewHolder(parent, layout)
    }

    override fun getItemCount(): Int {
        return CharacterList.size
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {
        holder.bind(CharacterList[position])
    }
}
