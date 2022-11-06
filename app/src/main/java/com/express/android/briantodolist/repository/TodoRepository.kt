package com.express.android.briantodolist.repository

import androidx.lifecycle.LiveData
import com.express.android.briantodolist.db.TodoDao
import com.express.android.briantodolist.db.TodoDatabase
import com.express.android.briantodolist.model.Todo
import kotlinx.coroutines.flow.Flow

class TodoRepository(private val todoDao: TodoDao) {

    val readAllData: LiveData<List<Todo>> = todoDao.readAllData()

    suspend fun addTodo(todo: Todo){
        todoDao.addTodo(todo)
    }

    suspend fun deleteTodo(todo: Todo){
        todoDao.deleteTodo(todo)
    }

    suspend fun updateTodo(todo: Todo){
        todoDao.updateTodo(todo)
    }

    //val getTodos: Flow<List<Todo>> = db.getTodoDao().getTodos()
}