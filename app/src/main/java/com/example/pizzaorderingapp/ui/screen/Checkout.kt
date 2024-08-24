package com.example.pizzaorderingapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CheckoutScreen(modifier: Modifier = Modifier, totalAmt: Float) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Text(
                text = "Total Amount: $totalAmt", fontSize =30.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    , color = (MaterialTheme.colorScheme.secondary)
            )
        }
    }
    }

@Preview
@Composable
private fun CheckoutScreenPreview() {
    CheckoutScreen(totalAmt = 0f)
}
