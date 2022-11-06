package com.express.android.briantodolist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.express.android.briantodolist.databinding.TodoItemBinding
import com.express.android.briantodolist.model.Todo
import com.express.android.briantodolist.ui.TodoItemDetail
import com.express.android.briantodolist.ui.TodoList
import com.express.android.briantodolist.ui.TodoListDirections
import com.express.android.briantodolist.viewmodels.TodoViewModel

class TodoItemAdapter() : RecyclerView.Adapter<TodoItemAdapter.TodoViewHolder>() {

    private var todoList = emptyList<Todo>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodoViewHolder {
        return TodoViewHolder(
            TodoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTodo = todoList[position]

        holder.binding.apply {
            idTxt.text = currentTodo.id.toString()
            name.text = currentTodo.name.toString()
        }

        holder.binding.rowLayout.setOnClickListener {
            val action = TodoListDirections.actionTodoListToTodoItemDetail(currentTodo)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

//    private val differCallback = object : DiffUtil.ItemCallback<Todo>(){
//        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
//            return oldItem.name == newItem.name
//        }
//
//        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    val differ = AsyncListDiffer(this, differCallback)

    fun setData(todo: List<Todo>){
        this.todoList = todo
        notifyDataSetChanged()
    }

    class TodoViewHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root)
}