package com.example.retrofitwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitwithmvvm.ViewModel.SecondPageViewModel

class SecondPage : AppCompatActivity() {
    lateinit var viewModel:SecondPageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)
        viewModel=ViewModelProvider(this,SecondPageViewModelFactory(this)).get(SecondPageViewModel::class.java)
        viewModel.raiseToast()
    }
}