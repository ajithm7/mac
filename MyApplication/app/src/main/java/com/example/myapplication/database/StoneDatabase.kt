package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//Create Database
@Database(entities=[StoneScissor::class],version=1,exportSchema=false)
abstract class StoneDatabase:RoomDatabase() {
    abstract val stoneDatabaseDao:StoneDatabaseDao
    companion object{
        @Volatile
        private var INSTANCE:StoneDatabase?=null
        fun getInstance(context: Context):StoneDatabase{
            synchronized(this){
                var instance= INSTANCE
                if(instance==null){
                    instance= Room.databaseBuilder(context.applicationContext,StoneDatabase::class.java,"stone_scissor_database").fallbackToDestructiveMigration().build()
                INSTANCE=instance
                }
                return instance
            }

        }

    }

}


