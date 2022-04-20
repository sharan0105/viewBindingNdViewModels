package com.example.retrofitwithmvvm.Repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitwithmvvm.api.QuotesApi
import com.example.retrofitwithmvvm.dataModel.Quotes

class Repo(private val quotesApi:QuotesApi) {
    //this class is needed bcoz it will have access to the interfaces and thru this only , we will
    //be able to access the functions that get the response of the api

    /*This repo will be called by the viewModel
    *
    * */
    private val quoteLiveData=MutableLiveData<Quotes>()
    val quote: LiveData<Quotes>
    get() = quoteLiveData
    //The get method will be called whenever the quote variable is called
    // it is like getting the value that is assigned to this variable
    suspend fun getQuotes(id:Int){
        val result=quotesApi.getQuotes(id)
        if(result?.body()!=null){
            quoteLiveData.postValue(result.body())
        }

    }
}