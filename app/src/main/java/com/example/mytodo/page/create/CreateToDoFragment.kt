package com.example.mytodo.page.create

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.mytodo.MainViewModel
import com.example.mytodo.R

class CreateToDoFragment: Fragment(R.layout.create_todo_fragment) {
    private val vm: MainViewModel by viewModels()
}
