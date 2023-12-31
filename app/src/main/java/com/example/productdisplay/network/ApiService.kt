package com.example.productdisplay.network

import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts(): ResponseModel
}