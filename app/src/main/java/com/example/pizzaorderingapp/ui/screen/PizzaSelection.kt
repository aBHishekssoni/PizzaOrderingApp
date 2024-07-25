package com.example.pizzaorderingapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzaorderingapp.R

@Composable
fun PizzaSelectionScreen(modifier: Modifier = Modifier) {
    val pizza = listOf("  Pepperoni ", "  Margherita ", "  Vegetarian  ", "  BBQ Chicken ", "  BBQ Chicken Deluxe ")
    val pimg = listOf(R.drawable._ceb5apai, R.drawable.pizza, R.drawable.pizza1, R.drawable.pizza_png_pepperoni_pizza_1000, R.drawable.pizza_png_pizza_png_image_3505)
    val pprice = listOf(100, 150, 200, 250, 300)
    var check =false
    Image(painter = painterResource(id = R.drawable.photo), contentDescription = null,
        modifier = Modifier.fillMaxSize()
            .size(1000.dp)
//            .weight(1f)
    )
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        itemsIndexed(pizza){
            index, item ->

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background

                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 30.dp
                ),
                modifier = Modifier
                    .padding(6.dp)
                    .width(400.dp)

            )  {
                Row (verticalAlignment= Alignment.CenterVertically){
                Image(painter = painterResource(id = pimg[index]), contentDescription = null,
                    modifier = Modifier
                        .size(400.dp)
                        .weight(1f)
                        .drawBehind {
                            drawCircle(
                                color = Color.Blue.copy(alpha = 0.1f),
                                radius = 800f
                            )
                            drawCircle(
                                color = Color.Red.copy(alpha = 0.2f),
                                radius = 600f
                            )
                            drawContext.transform.translate(
                                left = 5f,
                                top = -20f
                            )

                            drawCircle(
                                color = Color.Yellow.copy(alpha = 0.2f),
                                radius = 350f
                            )
                        }

                )

                    Text(text = item, style = MaterialTheme.typography.headlineSmall,

                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                    Text(text = "Rs ${pprice[index]}", style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,)

                }
            }
        }
    }

//    Box(modifier = Modifier
//        .fillMaxSize()
//        .background(MaterialTheme.colorScheme.primary)
//    )
}

@Preview
@Composable
private fun PizzaSelectionScreenPreview(){
    PizzaSelectionScreen()
}