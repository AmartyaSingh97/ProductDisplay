package com.example.productdisplay.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.productdisplay.Poppins
import com.example.productdisplay.data.Product
import com.example.productdisplay.viewmodel.ProductViewModel

@Composable
fun ProductDetailsScreen(
    viewModel: ProductViewModel,
    modifier: Modifier = Modifier,
    itemIndex : Int
) {

    val products by viewModel.products.observeAsState()

    LaunchedEffect(Unit){
        viewModel.fetchProducts()
    }
        products!!.products?.let { ProductDetails(it[itemIndex],modifier) }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductDetails(product: Product, modifier: Modifier) {

     Box(
          modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color(0xffffd700).copy(alpha = 0.05f))
     ){
          LazyColumn(
                modifier = Modifier
                 .fillMaxWidth()
                 .fillMaxHeight(),
              horizontalAlignment = Alignment.CenterHorizontally,
          ){
                item {
                 ImageSlider(product)
                }
              item {
                    ProductDetailsItem(product,modifier)
              }

          }
     }
}

@Composable
fun ProductDetailsItem(product: Product, modifier: Modifier){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(15.dp)
            .clip(
                shape = RoundedCornerShape(
                    20.dp
                )
            ).border(
                width = 1.dp,
                color = Color(0xFFADEBEC).copy(alpha = 0.05f)),
            ){

        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = product.title,
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .widthIn(max = 160.dp)
                    .heightIn(min = 16.dp)
                    .padding(top = 4.dp))

            Text(
                text = "Brand: ${product.brand}",
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .widthIn(max = 160.dp)
                    .heightIn(min = 16.dp)
                    .padding(top = 4.dp))

            Text(
                text = "${product.description} \n",
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .widthIn(max = 360.dp)
                    .heightIn(min = 16.dp)
                    .padding(top = 4.dp))

            Text(
                text = "Price: \$${product.price}",
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
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
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
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
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .widthIn(max = 160.dp)
                    .heightIn(min = 16.dp)
                    .padding(top = 4.dp))

            Text(
                text = "Stock: ${product.stock}",
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(product: Product){
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        product.images.size
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(15.dp)
            .clip(
                shape = RoundedCornerShape(
                    20.dp
                )
            ).border(
                width = 1.dp,
                color = Color(0xFFADEBEC).copy(alpha = 0.05f)),
    ) {
        Image(
            painter = rememberImagePainter(
                data = product.images[it],
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
    }
    Spacer(modifier = Modifier.padding(2.dp))

    DotsIndicator(
        totalDots = pagerState.pageCount,
        selectedIndex = pagerState.currentPage,
        selectedColor = Color(0xFF4DC2F8),
        unSelectedColor = Color(0xFFADEBEC)
    )
}

@Composable
fun DotsIndicator(
    totalDots : Int,
    selectedIndex : Int,
    selectedColor: Color,
    unSelectedColor: Color,
){

    LazyRow(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()

    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(selectedColor)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(unSelectedColor)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            }
        }
    }
}

