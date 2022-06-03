package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*

//Create Query
@Dao
interface StoneDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(stone: StoneScissor)

    @Update
    fun update(stone:StoneScissor)

    @Query("SELECT * FROM stone_scissor_result_table" )
    fun get():StoneScissor

    @Query("SELECT * FROM stone_scissor_result_table")
    fun clear()

    @Query("SELECT * FROM stone_scissor_result_table")
    fun getAllGames(): List<StoneScissor>

}