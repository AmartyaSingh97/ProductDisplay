package com.example.productdisplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.productdisplay.presentation.ProductDetailsScreen
import com.example.productdisplay.presentation.ProductListScreen
import com.example.productdisplay.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ProductViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "ProductListScreen"){
                composable("ProductListScreen"){
                    ProductListScreen(viewModel = viewModel, navController = navController)
                }
                composable("ProductDetailsScreen/{index}",
                    arguments = listOf(navArgument("index"){
                        type = NavType.IntType
                    })
                    ){index ->
                    ProductDetailsScreen(viewModel = viewModel, itemIndex = index.arguments?.getInt("index")?:0)
                }
            }

        }
    }
}

val Poppins = FontFamily(
    Font(
        resId = R.font.poppins,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.poppins_semibold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resId = R.font.poppins_bold,
        weight = FontWeight.Bold
    )
)
