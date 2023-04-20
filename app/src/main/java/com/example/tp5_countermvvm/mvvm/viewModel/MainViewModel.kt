package com.example.tp5_countermvvm.mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp5_countermvvm.mvvm.contract.MainContract

class MainViewModel(private val model: MainContract.Model): ViewModel(), MainContract.ViewModel{

    private val mutableLiveData: MutableLiveData<CounterData> = MutableLiveData()
    override fun getValue(): LiveData<CounterData> {
        return mutableLiveData
    }

    override fun incrementValue(value: Int) {
        model.increment(value)
        mutableLiveData.value = CounterData(CounterState.INC, model.counter)
    }

    override fun decrementValue(value: Int) {
        model.decrement(value)
        mutableLiveData.value = CounterData(CounterState.DEC, model.counter)
    }

    override fun resetValue(){
        model.reset()
        mutableLiveData.value = CounterData(CounterState.INITIAL)
    }

    data class CounterData(val state: CounterState = CounterState.INITIAL,
                           val value: Int = ZEROINT
    )

    enum class CounterState {
        INITIAL, INC, DEC
    }

    companion object{
        private const val ZEROINT = 0
    }
}