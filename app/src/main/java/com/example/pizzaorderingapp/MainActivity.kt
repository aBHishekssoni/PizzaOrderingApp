package com.example.pizzaorderingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pizzaorderingapp.ui.screen.CheckoutScreen
import com.example.pizzaorderingapp.ui.screen.PizzaSelectionScreen
import com.example.pizzaorderingapp.ui.screen.ToppingSelection
import com.example.pizzaorderingapp.ui.theme.PizzaOrderingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PizzaOrderingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var navController =rememberNavController()
                    NavHost(navController = navController, startDestination = "Pizza selection" ){
                        composable("Pizza selection"){
                            PizzaSelectionScreen(modifier = Modifier.padding(innerPadding)){

                                navController.navigate("Topping selection/$it")
                            }
                        }
                        composable("Topping selection/{pizzaid}",
                            arguments = listOf(navArgument("pizzaid"){
                                type= NavType.IntType
                            })
                            ){
                            ToppingSelection(modifier = Modifier.padding(innerPadding),
                                pizzaid = it.arguments?.getInt("pizzaid")?:0
                                ){
//                                navController.navigate("Checkout")
                            }
                        }
                        composable("Checkout"){
                            CheckoutScreen(modifier = Modifier.padding(innerPadding))
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ToppingSelectionPreview() {
    ToppingSelection(onConfirm = {

    }, pizzaid = 0)
}

@Preview
@Composable
private fun PizzaSelectionScreenPreview(){
    PizzaSelectionScreen(){

    }
}
@Preview
@Composable
private fun CheckoutScreenPreview() {
    CheckoutScreen()
}
