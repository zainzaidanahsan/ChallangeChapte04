package com.example.challangechapte04.ROOM

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataNote(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var tittle : String,
    var note : String
){
}
