package com.tech.assignment02.RoomData

import android.content.Context
import android.provider.CalendarContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Movies::class], version = 1)
abstract class MoviesDatabase:RoomDatabase (){
    abstract fun moviesDao() : MoviesDao
    companion object{
        var INSTANCE:MoviesDatabase?=null
        fun getInstance(context: Context):MoviesDatabase{
            if (INSTANCE==null){
                INSTANCE=Room.databaseBuilder(
                    context.applicationContext,
                    MoviesDatabase::class.java,
                    "Movies.db").build()

            }
            return INSTANCE!!
        }
    }
}