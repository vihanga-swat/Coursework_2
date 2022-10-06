package com.tech.assignment02.RoomData

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MoviesDao {

    @Insert
    suspend fun insert (movies: Movies)
    @Query("delete from Movies where mid=:mid")
    suspend fun delete(mid:Int)
    @Update
    suspend fun update(movies: Movies)
    @Query("select * from Movies")
    suspend fun display():List<Movies>
}