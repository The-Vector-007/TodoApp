package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao{

    @Insert
    suspend fun insertTodo( todo : TodoTable) : Long

    @Query(" Select * From TodoTable Where isFinished == 0 ")
    fun getTasks() : LiveData< List<TodoTable> >

    @Query( " Update TodoTable Set isFinished = 1 where id = :uid " )
    fun finishTask( uid : Long )

    @Query( " Delete From TodoTable where id = :uid " )
    fun deleteTask( uid : Long )
}