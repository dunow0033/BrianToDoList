package com.express.android.briantodolist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.express.android.briantodolist.R
import com.express.android.briantodolist.databinding.FragmentTodoItemDetailBinding
import com.express.android.briantodolist.viewmodels.TodoViewModel

class TodoItemDetail : Fragment() {

    private var _binding: FragmentTodoItemDetailBinding? = null
    private val binding: FragmentTodoItemDetailBinding get() = _binding!!

    private lateinit var todoViewModel: TodoViewModel

    private val args by navArgs<TodoItemDetailArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTodoItemDetailBinding.inflate(layoutInflater, container, false)

        binding.idTxt.setText(args.currentTodo.id.toString())
        binding.name.setText(args.currentTodo.name)

        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        if(args.currentTodo.detail == null)
            binding.detail.setText("")
        else
            binding.detail.setText(args.currentTodo.detail)

        val bundle = bundleOf("currentTodo" to args.currentTodo)

        binding.updateButton.setOnClickListener {
            findNavController().navigate(R.id.TodoDetailToTodoUpdate, bundle)
        }

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.TodoDetailToTodoList)
        }

        binding.deleteButton.setOnClickListener {
            todoViewModel.deleteTodo(args.currentTodo)
            findNavController().navigate(R.id.TodoDetailToTodoList)


            //maybe put this Toast in later
            //Toast.makeText(context,"${todoViewModel.readAllData.value?.get(int)?.todoTask}", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}