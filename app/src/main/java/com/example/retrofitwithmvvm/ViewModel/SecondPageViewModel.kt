package com.example.retrofitwithmvvm.ViewModel

import android.content.Context
import android.widget.Toast
import androidx.core.content.contentValuesOf
import androidx.lifecycle.ViewModel

class SecondPageViewModel(private  val context: Context):ViewModel() {
    fun raiseToast(){
        Toast.makeText(context,"Welcome to this page",Toast.LENGTH_SHORT).show()
    }
}