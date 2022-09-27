package com.example.challangechapte04.Room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class DataNote(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var tittle : String,
    var note : String
): Serializable
