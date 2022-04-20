package com.example.retrofitwithmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitwithmvvm.Repo.Repo
import com.example.retrofitwithmvvm.ViewModel.MainViewModel
import com.example.retrofitwithmvvm.api.QuotesApi
import com.example.retrofitwithmvvm.api.RetrofitBuilder
import com.example.retrofitwithmvvm.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val apiInterface=RetrofitBuilder.getInstance().create(QuotesApi::class.java)
        val repo= Repo(apiInterface)
        //bcoz this viewModel has a parameter , it will be provided by a factory, so u need to specify the
        //factory and get the viewModel you want to
        btnGetRandomQuote.setOnClickListener {
            val userId=binding.etId.text.toString().toInt()
            viewModel=ViewModelProvider(this,MainViewModelFactory(repo,userId)).get(MainViewModel::class.java)
            viewModel.quoteData.observe(this, Observer {
                val randomQuote=it.results[userId].content.toString()
                binding.tvQuote.text=randomQuote
            })
        }
        }
    }