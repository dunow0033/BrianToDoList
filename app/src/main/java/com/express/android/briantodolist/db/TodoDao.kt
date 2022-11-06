package com.express.android.briantodolist.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.express.android.briantodolist.model.Todo

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTodo(todo: Todo)

//    @Query("SELECT * FROM todos")
//    fun getTodos() : Flow<List<Todo>>

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Todo>>

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Update
    suspend fun updateTodo(todo: Todo)
}