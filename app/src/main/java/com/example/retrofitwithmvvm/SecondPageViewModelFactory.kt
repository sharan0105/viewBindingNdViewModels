package com.example.retrofitwithmvvm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitwithmvvm.ViewModel.SecondPageViewModel

class SecondPageViewModelFactory(private val context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SecondPageViewModel(context) as T
    }

}