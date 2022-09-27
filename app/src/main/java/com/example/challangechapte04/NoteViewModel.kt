package com.example.challangechapte04

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.challangechapte04.Room.DataNote
import com.example.challangechapte04.Room.NoteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class NoteViewModel(app: Application) : AndroidViewModel(app) {
    var datalistNote : MutableLiveData<List<DataNote>>

    init {
        datalistNote = MutableLiveData()
        getAllNote()
     }
    fun noteObserve(): MutableLiveData<List<DataNote>>{
        return datalistNote
    }
    fun getAllNote(){
        GlobalScope.launch {
            val noteDao = NoteDatabase.getInstance((getApplication()))?.noteDao()
            val listNote = noteDao?.getDataNote()
            datalistNote.postValue(listNote!!)
        }
    }

    fun insertNote(note : DataNote){
        GlobalScope.async {
            val noteDao = NoteDatabase.getInstance(getApplication())?.noteDao()
            noteDao?.insertNote(note)
            getAllNote()
        }
    }
    fun deleteNote(note: DataNote){
        GlobalScope.async {
            val noteDao = NoteDatabase.getInstance(getApplication())?.noteDao()
            noteDao?.deleteNote(note)
            getAllNote()
        }
    }
    fun editNote(note: DataNote){
        GlobalScope.async {
            val noteDao = NoteDatabase.getInstance(getApplication())?.noteDao()
            noteDao?.updateNote(note)
            getAllNote()
        }
    }



}