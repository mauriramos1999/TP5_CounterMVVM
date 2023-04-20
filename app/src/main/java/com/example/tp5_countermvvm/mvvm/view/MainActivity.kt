package com.example.tp5_countermvvm.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
//import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.tp5_countermvvm.R
import com.example.tp5_countermvvm.databinding.ActivityMainBinding
import com.example.tp5_countermvvm.mvvm.model.MainModel
import com.example.tp5_countermvvm.mvvm.viewModel.MainViewModel
import com.example.tp5_countermvvm.mvvm.viewModel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        //CON DATA BINDING
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        binding.viewModel = ViewModelProvider(this, ViewModelFactory(arrayOf(MainModel()))).get(
            MainViewModel::class.java)

        binding.increment.setOnClickListener{binding.viewModel!!.
            incrementValue(getInputValue().toInt())}

        binding.decrement.setOnClickListener{binding.viewModel!!.
            decrementValue(getInputValue().toInt())}

        binding.reset.setOnClickListener{binding.viewModel!!.resetValue()}

        binding.viewModel?.getValue()?.observe(this){updateUI(it)}

        */

        //  CON VIEW BINDING
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: MainViewModel = ViewModelProvider(this, ViewModelFactory(arrayOf(MainModel()))).
            get(MainViewModel::class.java)

        binding.increment.setOnClickListener{viewModel!!.
            incrementValue(getInputValue().toInt())}

        binding.decrement.setOnClickListener{viewModel!!.
            decrementValue(getInputValue().toInt())}

        binding.reset.setOnClickListener{viewModel!!.resetValue()}

        viewModel?.getValue()?.observe(this){updateUI(it)}
    }

    private fun updateUI(x: MainViewModel.CounterData){
        when(x.state){
            MainViewModel.CounterState.INITIAL -> {
                binding.counter.text = ZERO_STRING
                showToast("Reset done")
            }
            MainViewModel.CounterState.INC -> {
                binding.counter.text = x.value.toString()
                showToast("Increment done")
            }
            MainViewModel.CounterState.DEC -> {
                binding.counter.text = x.value.toString()
                showToast("Decrement done")
            }
        }

    }

    fun getInputValue(): String{
        return binding.inputCount.text.toString().ifEmpty { ZERO_STRING }
    }

    fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val ZERO_STRING = "0"
    }
}