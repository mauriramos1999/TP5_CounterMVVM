package com.example.tp5_countermvvm.mvvm.model

import com.example.tp5_countermvvm.databinding.ActivityMainBinding
import com.example.tp5_countermvvm.mvvm.contract.MainContract

class MainModel: MainContract.Model {

    override var counter: Int = ZEROINT


    override fun increment(value: Int) {
        counter += value
    }

    override fun decrement(value: Int) {
        counter -= value
    }

    override fun reset() {
        counter = 0
    }

    companion object{
        private const val ZEROINT = 0
    }
}