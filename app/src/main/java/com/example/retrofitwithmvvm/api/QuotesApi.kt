package com.example.retrofitwithmvvm.api

import com.example.retrofitwithmvvm.dataModel.Quotes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {
    //this interface contains fns which will be called to get the response from the api
    @GET("quotes") //this {} tells that function that id is a parameter
    suspend fun getQuotes(@Query("id")id:Int): Response<Quotes>
    //this function will be responsible for getting the quotes ,our repo
    //will call this function and then from the repo , this will go to the viewModel
    //and then to the MainActivity


}