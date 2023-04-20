package com.example.tp5_countermvvm.mvvm.contract

import androidx.lifecycle.LiveData
import com.example.tp5_countermvvm.mvvm.viewModel.MainViewModel

interface MainContract {

    interface ViewModel{
        fun getValue(): LiveData<MainViewModel.CounterData>
        fun incrementValue(value: Int)
        fun decrementValue(value: Int)
        fun resetValue()
    }

    interface Model{
        var counter: Int
        fun increment(value: Int)
        fun decrement(value: Int)
        fun reset()
    }
}