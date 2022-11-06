package com.express.android.briantodolist.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.express.android.briantodolist.db.TodoDatabase
import com.express.android.briantodolist.model.Todo
import com.express.android.briantodolist.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(app: Application) : AndroidViewModel(app) {

    val readAllData: LiveData<List<Todo>>
    private val repo: TodoRepository

    init {
        val todoDao = TodoDatabase.getDatabase(app).todoDao()
        repo = TodoRepository(todoDao)
        readAllData = repo.readAllData
    }

//    fun getAllTodos() {
//        viewModelScope.launch {
//            repo.getTodos.collect {
//                _todos.postValue(it)
//            }
//        }
//    }

    fun addTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addTodo(todo)
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            repo.deleteTodo(todo)
        }
    }

    fun updateTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateTodo(todo)
        }
    }
}