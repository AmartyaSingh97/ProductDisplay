package com.example.productdisplay.network

import com.example.productdisplay.data.Product
import com.google.gson.annotations.SerializedName

class ResponseModel {

    @SerializedName("products")
    var products: List<Product>? = null

    @SerializedName("total")
    var total: Int? = null

    @SerializedName("skip")
    var skip: Int? = null

    @SerializedName("limit")
    var limit: Int? = null

}