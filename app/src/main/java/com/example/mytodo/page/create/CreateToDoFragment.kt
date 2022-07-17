package com.example.mytodo.page.create

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mytodo.R
import com.example.mytodo.databinding.CreateTodoFragmentBinding
import com.example.mytodo.util.showLongSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateToDoFragment: Fragment(R.layout.create_todo_fragment) {
    private val vm: CreateToDoViewModel by viewModels()

    private lateinit var binding: CreateTodoFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = CreateTodoFragmentBinding.inflate(inflater, container, false).root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.uiEvent.observe(viewLifecycleOwner) { uiEvent ->
            when (uiEvent) {
                is CreateToDoViewModel.UiEvent.Error -> {
                    showLongSnackBar(uiEvent.error)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_create, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_save -> {
                save()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun save() {
        val title = binding.titleEdit.text.toString()
        val detail = binding.titleEdit.text.toString()
        vm.save(title, detail)
    }
}
