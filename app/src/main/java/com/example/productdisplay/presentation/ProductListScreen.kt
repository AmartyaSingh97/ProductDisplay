package com.example.productdisplay.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.productdisplay.viewmodel.ProductViewModel

@Composable
fun ProductListScreen(viewModel: ProductViewModel) {

    val products by viewModel.products.observeAsState()
    
    LaunchedEffect(Unit){
        viewModel.fetchProducts()
    }

    if(products?.products ==null){
        Row(verticalAlignment = Alignment.CenterVertically) {
            CircularProgressIndicator(
                modifier = Modifier.size(size = 28.dp),
                color = Color.Red
            )
            Spacer(modifier = Modifier.width(width = 8.dp))
            Text(text = "Loading...")
        }
    }else{
        Text(text = products!!.products?.size.toString())
    }

}