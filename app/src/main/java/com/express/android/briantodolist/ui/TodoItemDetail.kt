package com.express.android.briantodolist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.express.android.briantodolist.R
import com.express.android.briantodolist.databinding.FragmentTodoItemDetailBinding

class TodoItemDetail : Fragment() {

    private var _binding: FragmentTodoItemDetailBinding? = null
    private val binding: FragmentTodoItemDetailBinding get() = _binding!!

    private val args by navArgs<TodoItemDetailArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTodoItemDetailBinding.inflate(layoutInflater, container, false)

        binding.idTxt.setText(args.currentTodo.id.toString())
        binding.name.setText(args.currentTodo.name)
        if(args.currentTodo.detail == null)
            binding.detail.setText("")
        else
            binding.detail.setText(args.currentTodo.detail)

        binding.updateButton.setOnClickListener {
            findNavController().navigate(R.id.TodoDetailToTodoUpdate)
        }

        return binding.root
    }
}