package com.example.pizzaorderingapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import java.util.zip.CheckedOutputStream

@Composable
fun CheckoutScreen(modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue))

    }

@Preview
@Composable
private fun CheckoutScreenPreview() {
    CheckoutScreen()
}
