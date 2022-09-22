package com.example.mytodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodo.databinding.MainFragmentBinding
import com.example.mytodo.model.todo.ToDo
import com.example.mytodo.util.showLongSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: Fragment(R.layout.main_fragment) {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fav.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_createToDoFragment)
        }
        val adapter = ToDoAdapter()
        adapter.setOnClickListener(object : ToDoAdapter.OnItemClickListener {
            override fun onItemClickListener(view: View, position: Int, clickedToDo: ToDo) {
                // TODO: TODO編集fragmentをつくってそこに遷移するようにする！
                showLongSnackBar(clickedToDo.title)
            }
        })
        binding.recycler.adapter = adapter

        // LayoutMangerでGridのリストを作成するのか、ふつうのtableViewぽく作るのかを設定できる。
        // binding.recycler.layoutManager = LinearLayoutManager(this.context)
        binding.recycler.layoutManager = GridLayoutManager(context, 1, RecyclerView.VERTICAL, false)
        viewModel.todoList.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
    }
}
