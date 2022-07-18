package com.example.mytodo.page.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytodo.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class CreateToDoViewModel @Inject constructor(
    private val repository: ToDoRepository
): ViewModel() {

    sealed class UiEvent {
        data class Error(val error: String) : UiEvent()
        object Done : UiEvent()
    }

    private val _uiEvent: MutableLiveData<UiEvent> = MutableLiveData<UiEvent>()
    val uiEvent: LiveData<UiEvent> = _uiEvent

    fun save(title: String, detail: String) {
        if (title.trim().isEmpty() || detail.isEmpty()) {
            _uiEvent.value = UiEvent.Error("error" )
            return
        }

        viewModelScope.launch {
            try {
                repository.create(title, detail)
                _uiEvent.value = UiEvent.Done
            } catch (e: Exception) {
                _uiEvent.value = UiEvent.Error(e.message.toString())
            }
        }
    }
}
