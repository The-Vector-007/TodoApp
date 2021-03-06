package com.example.todoapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoTable(
        var title : String,
        var description : String,
        var category : String,
        var date : Long,
        var time : Long,
        var isFinished : Int = 0,
        @PrimaryKey(autoGenerate = true) // make the primary key as last parameter to the constructor
        var id : Long = 0                // else you will need to pass its value each time
)