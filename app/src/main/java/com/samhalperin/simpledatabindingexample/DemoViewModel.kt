package com.samhalperin.simpledatabindingexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class DemoViewModel : ViewModel() {
    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    init {
        _msg.value = "init"
        viewModelScope.launch {
            var i = 0
            while(true) {
                _msg.value = i.toString()
                delay(2000)
                i++
            }
        }
    }
}