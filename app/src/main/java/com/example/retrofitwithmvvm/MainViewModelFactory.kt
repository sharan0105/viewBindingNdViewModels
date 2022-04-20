package com.example.retrofitwithmvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitwithmvvm.Repo.Repo
import com.example.retrofitwithmvvm.ViewModel.MainViewModel

class MainViewModelFactory(private val repo:Repo,val id:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo,id) as T
    }

}