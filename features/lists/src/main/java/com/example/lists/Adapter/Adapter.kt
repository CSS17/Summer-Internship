package com.example.presentation.Adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lists.Adapter.StatusNumber
import com.example.lists.R
import com.example.rickandmorty.models.Result
import com.example.lists.Adapter.StatusType
class Adapter(val CharacterList: List<Result>):RecyclerView.Adapter<ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        //var get_selection=status_selection.get_status(CharacterList[position].toString())
        when(CharacterList[position].status){
            StatusType.DEAD.StatusType-> return StatusNumber.DEAD.number
            StatusType.ALIVE.StatusType-> return StatusNumber.ALIVE.number
            else-> return StatusNumber.UNKNOWN.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = if(viewType == StatusNumber.DEAD.number) R.layout.dead
        else if(viewType == StatusNumber.ALIVE.number) R.layout.alive
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
