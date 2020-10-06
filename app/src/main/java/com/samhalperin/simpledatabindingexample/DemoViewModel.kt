package com.samhalperin.simpledatabindingexample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * A simple view model for demo purposes.
 */
class DemoViewModel : ViewModel() {
    private val _msg = MutableLiveData<String>()

    /**
     * The single property exposed by this view model.  Driven
     * by the coroutine in init, it will count up from 0, every
     * 2 seconds.
     */
    val msg: LiveData<String> = _msg
    var counterJob: Job? = null


    init {
       resetCounter("hello init")
    }

    /**
     * While this looks like an infinite loop (and it is), the Job
     * will be cancelled automatically when the view model goes out of scope.
     * @param log Used to demonstrate 2-way binding. Pass data from the template
     * into the view model.
     */
    fun resetCounter(log: String) {
        Log.d(DemoViewModel::class.java.simpleName, log)
        counterJob?.cancel()
        counterJob = viewModelScope.launch {
            var i = 0
            while(true) {
                _msg.value = i.toString()
                delay(2000)  // note kotlinx.coroutines.delay not Thread.sleep
                i++
            }
        }
    }
}