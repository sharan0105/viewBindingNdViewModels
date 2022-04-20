package com.example.retrofitwithmvvm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitwithmvvm.Repo.Repo
import com.example.retrofitwithmvvm.dataModel.Quotes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (private val repo:Repo,val id:Int): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getQuotes(id)
        }
    }
    val quoteData:LiveData<Quotes>
    get() = repo.quote
       //This will update the value of the mutable live data
        //once that gets updated , whenever the value of the live data is called from the repo ,
        // it will get updated and now , the value of the quoteData in the MainViewModel will also get updated
    }