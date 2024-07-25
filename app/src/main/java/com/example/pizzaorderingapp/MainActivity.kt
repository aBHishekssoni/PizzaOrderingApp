package com.example.pizzaorderingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                            PizzaSelectionScreen(modifier = Modifier.padding(innerPadding))
                        }
                        composable("Topping selection"){
                            ToppingSelection(modifier = Modifier.padding(innerPadding))
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PizzaOrderingAppTheme {
        Greeting("Android")
    }
}