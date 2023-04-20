package com.example.tp5_countermvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.tp5_countermvvm.mvvm.contract.MainContract
import com.example.tp5_countermvvm.mvvm.model.MainModel
import com.example.tp5_countermvvm.mvvm.view.MainActivity
import com.example.tp5_countermvvm.mvvm.viewModel.MainViewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MainViewModelTest{

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainContract.ViewModel

    @Before
    fun setup(){
        viewModel = MainViewModel(MainModel())
    }

    @Test
    fun `initialStateTest`(){
        assert( viewModel.getValue().value == null)
    }

    @Test
    fun `onPressedResetStateTest`(){
        viewModel.resetValue()

        assert(viewModel.getValue().value?.value == ZERO_INT)
        assert(viewModel.getValue().value?.state == MainViewModel.CounterState.INITIAL)

    }

    @Test
    fun `on Increment button pressed after Reset`(){
        viewModel.resetValue()

        viewModel.incrementValue(SEVEN_INT)

        assert(viewModel.getValue().value?.value == SEVEN_INT)
        assert(viewModel.getValue().value?.state == MainViewModel.CounterState.INC)
    }

    @Test
    fun `on Decrement button pressed after Reset`(){
        viewModel.resetValue()
        viewModel.decrementValue(FIVE_INT)

        assert(viewModel.getValue().value?.value == -FIVE_INT)
        assert(viewModel.getValue().value?.state == MainViewModel.CounterState.DEC)
    }


    companion object {
        private const val ZERO_INT = 0
        private const val FIVE_INT = 5
        private const val SEVEN_INT = 7
    }

}