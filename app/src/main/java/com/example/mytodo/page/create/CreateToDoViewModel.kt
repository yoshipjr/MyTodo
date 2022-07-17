package com.example.mytodo.page.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateToDoViewModel: ViewModel() {

    sealed class UiEvent {
        data class Error(val error: String) : UiEvent()
    }

    private val _uiEvent: MutableLiveData<UiEvent> = MutableLiveData<UiEvent>()
    val uiEvent: LiveData<UiEvent> = _uiEvent

    fun save(title: String, detail: String) {
        if (title.trim().isEmpty() || detail.isEmpty()) {
            _uiEvent.value = UiEvent.Error("error" )
            return
        }
    }
}
