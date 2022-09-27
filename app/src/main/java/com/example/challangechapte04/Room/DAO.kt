package com.example.challangechapte04.Room

import androidx.room.*

@Dao
interface DAO {
    @Insert
    fun insertNote(note: DataNote)

    @Query("SELECT * FROM DataNote ORDER BY id DESC ")
    fun getDataNote() : List<DataNote>

    @Delete
    fun deleteNote(note: DataNote)

    @Update
    fun updateNote(note: DataNote)

    @Query("SELECT COUNT(*) FROM DataNote")
    fun checkData() : Int
}