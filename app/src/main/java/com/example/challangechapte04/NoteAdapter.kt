package com.example.challangechapte04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.challangechapte04.Room.DataNote
import com.example.challangechapte04.Room.NoteDatabase
import com.example.challangechapte04.databinding.ItemNoteBinding

class NoteAdapter(var listNote : List<DataNote>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    var dbNote : NoteDatabase? = null
    var delete : ((DataNote) -> Unit)? = null
    var edit : ((DataNote) -> Unit)? = null

    class ViewHolder(var binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root){
        fun getDataBind(itemData: DataNote){
            binding.dataNote = itemData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolder {
        var view =ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        holder.getDataBind(listNote[position])
        var note = listNote[position].note
        var tittle = listNote[position].tittle
        var id = listNote[position].id.toString()
        holder.binding.cardViewItem.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val bundle = Bundle()
                bundle.putString("note", note)
                bundle.putString("tittle", tittle)
                bundle.putString("id", id)
                Navigation.findNavController(holder.itemView).navigate(R.id.action_homeFragment_to_detailFragment, bundle)
            }

        })
        holder.binding.btnDelete.setOnClickListener{
            delete!!.invoke(listNote[position])
        }
        holder.binding.btnEdit.setOnClickListener{
//            edit!!.invoke(listNote[position])

        }
    }

    override fun getItemCount(): Int {
        return listNote.size
    }
    fun setNote(listNote: ArrayList<DataNote>){
        this.listNote =listNote
    }
}