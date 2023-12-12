package com.example.productdisplay.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productdisplay.network.ApiService
import com.example.productdisplay.network.ResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(private val apiService: ApiService): ViewModel(){

    private val _items = MutableLiveData<ResponseModel>()
    val products: LiveData<ResponseModel> = _items

    fun fetchProducts(){
         viewModelScope.launch {
             try{
                val response = apiService.getProducts()
                 _items.value = response
             }
             catch (e: Exception){
                 _items.value = null
             }
         }
    }

}