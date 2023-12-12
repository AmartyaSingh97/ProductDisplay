package com.example.productdisplay.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.productdisplay.Poppins
import com.example.productdisplay.data.Product
import com.example.productdisplay.viewmodel.ProductViewModel

@Composable
fun ProductListScreen(viewModel: ProductViewModel, navController: NavController) {

    val products by viewModel.products.observeAsState()
    
    LaunchedEffect(Unit){
        viewModel.fetchProducts()
    }

    if(products?.products ==null){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
            ) {
            CircularProgressIndicator(
                modifier = Modifier.size(size = 28.dp),
                color = Color.Red
            )
            Spacer(modifier = Modifier.width(width = 8.dp))
            Text(
                text = "Loading...",
                color = Color.Black,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,),
                modifier = Modifier
                    .width(140.dp)
                    .heightIn(min = 16.dp)
                    .padding(top = 4.dp))
        }
    }else{
        products!!.products?.let { ProductList(navController = navController,products = it) }
    }
}

@Composable
fun ProductList(
    modifier: Modifier = Modifier,
    products: List<Product>,
    navController: NavController
) {
    
    LazyColumn(
        modifier.background(color = Color(0xffffd700).copy(alpha = 0.05f)),
        contentPadding = PaddingValues(12.dp)){
        items(count = products.size){
            ProductListItem(
                modifier = modifier,
                product = products[it],
                itemIndex = it,
                navController = navController
            )
        }
    }
}

@Composable
fun ProductListItem(
    modifier: Modifier = Modifier,
    product: Product,
    itemIndex: Int,
    navController: NavController
) {

    Card(
        modifier
            .padding(10.dp)
            .border(
                width = 1.dp,
                color = Color(0xFF4DC2F8),
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
            .clickable {
                navController.navigate(
                    route = "ProductDetailsScreen/$itemIndex",
                )
            }
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFffdab9),
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ){
        Row(
            modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ){

            Column(
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = product.thumbnail),
                    contentDescription = product.description,
                    modifier = modifier
                        .size(140.dp)
                        .clip(RoundedCornerShape(20.dp))
                    ,
                    contentScale = androidx.compose.ui.layout.ContentScale.FillBounds
                )

                Text(
                    text = product.title,
                    color = Color.Black,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(140.dp)
                        .heightIn(min = 16.dp)
                        .padding(top = 4.dp))
            }

            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxHeight()
                ,
                verticalArrangement = Arrangement.SpaceEvenly

            ) {

                Text(
                    text = "Brand: ${product.brand}",
                    color = Color.Black,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .widthIn(max = 160.dp)
                        .heightIn(min = 16.dp)
                        .padding(top = 4.dp))

                Text(
                    text = "Price: \$${product.price}",
                    color = Color.Black,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .widthIn(max = 160.dp)
                        .heightIn(min = 16.dp)
                        .padding(top = 4.dp))


                Text(
                    text = "Discount: ${product.discountPercentage}%",
                    color = Color.Black,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .widthIn(max = 160.dp)
                        .heightIn(min = 16.dp)
                        .padding(top = 4.dp))

                Text(
                    text = "Rating: ${product.rating}",
                    color = Color.Black,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.SemiBold,),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .widthIn(max = 160.dp)
                        .heightIn(min = 16.dp)
                        .padding(top = 4.dp))

            }
        }
    }

}


