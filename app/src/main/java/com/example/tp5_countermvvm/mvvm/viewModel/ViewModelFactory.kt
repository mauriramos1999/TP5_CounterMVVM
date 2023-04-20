package com.example.tp5_countermvvm.mvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tp5_countermvvm.mvvm.contract.MainContract

class ViewModelFactory(private val params: Array<Any>) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when(modelClass){
            MainViewModel::class.java -> MainViewModel(params[0] as MainContract.Model) as T
            else -> throw IllegalArgumentException("Unknown viewModel Class: ${modelClass.name}")
        }
    }
}