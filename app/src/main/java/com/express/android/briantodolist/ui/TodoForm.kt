package com.express.android.briantodolist.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.express.android.briantodolist.R
import com.express.android.briantodolist.databinding.FragmentTodoFormBinding
import com.express.android.briantodolist.model.Todo
import com.express.android.briantodolist.viewmodels.TodoViewModel

class TodoForm : Fragment() {

    private var _binding: FragmentTodoFormBinding? = null
    private val binding: FragmentTodoFormBinding get() = _binding!!

    private lateinit var todoViewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTodoFormBinding.inflate(inflater, container, false)

        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        binding.submitButton.setOnClickListener {
            insertDataToDatabase()
        }

        binding.seeList.setOnClickListener {
            findNavController().navigate(R.id.TodoFormToTodoList)
        }

        return binding.root
    }

    private fun insertDataToDatabase() {
        with(binding) {
            val name = etName.text.toString()
            val details = etDetails.text.toString()

            if (inputCheck(name)) {
                val todo = Todo(0, name, details)
                todoViewModel.addTodo(todo)
                findNavController().navigate(R.id.TodoFormToTodoList)
                Toast.makeText(
                    requireContext(),
                    "Item successfully added!!",
                    Toast.LENGTH_SHORT).show()
                etName.setText("")
                etDetails.setText("")
            } else {
                Toast.makeText(
                    context,
                    "Please enter the name of the item to be completed",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun inputCheck(name: String): Boolean {
        return !TextUtils.isEmpty(name)
    }
}