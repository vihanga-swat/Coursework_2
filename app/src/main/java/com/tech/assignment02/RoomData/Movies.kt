package com.tech.assignment02.RoomData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName="Movies")
data class Movies(

    @PrimaryKey(autoGenerate = true)
    val mid:Int?,
    val Title:String?,
    val Year:String?,
    val Rated:String?,
    val Released:String?,
    val Runtime:String?,
    val Genre:String?,
    val Director:String?,
    val Writer:String?,
    val Actors:String?,
    val Plot:String?,
)