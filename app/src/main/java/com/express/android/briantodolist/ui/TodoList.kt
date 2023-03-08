package com.express.android.briantodolist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.express.android.briantodolist.R
import com.express.android.briantodolist.adapters.TodoItemAdapter
import com.express.android.briantodolist.databinding.FragmentTodoListBinding
import com.express.android.briantodolist.viewmodels.TodoViewModel

class TodoList : Fragment() {

    private var _binding: FragmentTodoListBinding? = null
    private val binding: FragmentTodoListBinding get() = _binding!!

    private lateinit var todoViewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTodoListBinding.inflate(inflater, container, false)

        val adapter = TodoItemAdapter()
        val recyclerView = binding.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        todoViewModel.readAllData.observe(viewLifecycleOwner, Observer { todo ->
            adapter.setData(todo)
        })

        binding.homeButton.setOnClickListener {
            findNavController().navigate(R.id.TodoListToTodoForm)
        }

        return binding.root
    }
}