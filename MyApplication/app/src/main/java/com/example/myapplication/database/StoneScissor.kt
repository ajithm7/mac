package com.example.myapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Create Table
@Entity(tableName = "stone_scissor_result_table")
data class StoneScissor (
    @PrimaryKey(autoGenerate = true)
    var gameId:Long=0L,
    @ColumnInfo(name="player_one_name")
    var playerOneName:String="Player 1",
    @ColumnInfo(name="player_two_name")
    var playerTwoName:String="Player 2",
    @ColumnInfo(name="winner_name")
    var winnerName:String="You"
)