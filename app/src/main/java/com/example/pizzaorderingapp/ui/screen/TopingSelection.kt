package com.example.pizzaorderingapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.lang.Boolean

@Composable
fun ToppingSelection(modifier: Modifier = Modifier) {
//    Box(modifier = Modifier
//        .fillMaxSize()
//        .background(Color.DarkGray))

val toppingList = listOf("onion","mushroom","tomato","pepper","cheese","pepperoni","chicken","chicken sausage","paneer","olives")
    val toppingPrice = listOf(10,20,30,40,50,60,70,80,90,100)
    var selectedTopping by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()

    ) {
        itemsIndexed(toppingList){
            index, item ->
            Card(
                onClick = {
                    selectedTopping = !selectedTopping

                },
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 30.dp
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .fillParentMaxWidth()
            ) {
                Checkbox(checked = selectedTopping, onCheckedChange = { selectedTopping = it })

                Text(text = item, style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground)
                Text(text = "Rs ${ toppingPrice[index] }", style = MaterialTheme.typography.headlineSmall,)

            }
        }

    }

}

@Preview
@Composable
private fun ToppingSelectionPreview() {
    ToppingSelection()
}