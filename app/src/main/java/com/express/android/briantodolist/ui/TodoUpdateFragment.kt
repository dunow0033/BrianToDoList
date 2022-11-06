package com.express.android.briantodolist.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.express.android.briantodolist.R
import com.express.android.briantodolist.databinding.FragmentTodoItemDetailBinding
import com.express.android.briantodolist.databinding.FragmentTodoUpdateBinding
import com.express.android.briantodolist.model.Todo
import com.express.android.briantodolist.viewmodels.TodoViewModel

class TodoUpdateFragment : Fragment() {

    private lateinit var _binding: FragmentTodoUpdateBinding
    private val binding: FragmentTodoUpdateBinding get() = _binding!!

    private lateinit var todoViewModel: TodoViewModel

    //private val args by navArgs<TodoUpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTodoUpdateBinding.inflate(layoutInflater, container, false)

        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

//        binding.etName.setText(args.currentTodo.name)
//        binding.etDetails.setText(args.currentTodo.detail)

        binding.updateButton.setOnClickListener {
            updateItem()
        }

        return binding.root
    }

    private fun updateItem() {
        val todoName = binding.etName.text.toString()
        val todoDetails = binding.etDetails.text.toString()

//        if(inputCheck(todoName)) {
//            val updateTodo = Todo(args.currentTodo.id, todoName, todoDetails)
//
//            todoViewModel.updateTodo(updateTodo)
//            Toast.makeText(requireContext(), "Successfully updated!!", Toast.LENGTH_LONG).show()
//            findNavController().navigate(R.id.TodoItemUpdateToTodoList)
//        } else {
//            Toast.makeText(requireContext(), "Please fill out the name field!!", Toast.LENGTH_LONG).show()
//        }
    }

    private fun inputCheck(todoName: String): Boolean {
        return !TextUtils.isEmpty(todoName)
    }
}