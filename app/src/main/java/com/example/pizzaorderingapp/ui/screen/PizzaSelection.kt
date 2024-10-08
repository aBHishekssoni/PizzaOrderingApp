package com.example.pizzaorderingapp.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaorderingapp.Pizza
import com.example.pizzaorderingapp.PizzaType
import com.example.pizzaorderingapp.R
import com.example.pizzaorderingapp.dummyPizzaList

@Composable
fun PizzaSelectionScreen(modifier: Modifier = Modifier,
onConfirm: (Int) -> Unit,) {
var SelectedPizza by remember { mutableStateOf<Pizza?>(null) }
    var selectedPizzaIndex by remember { mutableIntStateOf(-1) }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.tertiary)){
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            itemsIndexed(dummyPizzaList()){idx,it->
                PizzaItem(pizza = it){item->
                    SelectedPizza = it
                    dummyPizzaList().indexOf(item).let { itemIdx ->
                        selectedPizzaIndex = itemIdx
                    }
                }
            }
            }
        AnimatedVisibility(SelectedPizza != null) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.secondaryContainer
                    )
                    .padding(16.dp),
            ){
                Text(text = "Selected Pizza: ${SelectedPizza?.name} ${SelectedPizza?.price}")
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { SelectedPizza=null }) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "Close")
                }

            }
        }

        FloatingActionButton(onClick = {
            if (selectedPizzaIndex != -1) {
                onConfirm(selectedPizzaIndex)
            }
        },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            shape = MaterialTheme.shapes.extraLarge,
            containerColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = "Done"
            )
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaItem(
    modifier: Modifier = Modifier,
    pizza: Pizza,
    onPizzaSelected: (Pizza) -> Unit = {}
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onPizzaSelected(pizza) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = pizza.image),
                contentDescription = pizza.name,
                modifier = Modifier.size(200.dp)
            )
            Column(
                modifier
                    .height(200.dp)
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,

                ) {
                Text(
                    text = pizza.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.basicMarquee()
                )
                Text(
                    text = "Rs ${pizza.price}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.Blue.copy(alpha = .6f)
                )
                Box(
                    modifier = Modifier
                        .background(Color.Gray)
                        .padding(4.dp),
                ) {
                    Text(
                        text = pizza.pizzaType.name,
                        color = when (pizza.pizzaType) {
                            PizzaType.VEG -> Color.Green
                            PizzaType.NonVeg -> Color.Red
                        },
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun PizzaItemPreview() {
    PizzaItem(
        pizza =  Pizza(
            "Margherita",
            150.00,
            R.drawable.pizza_png_from_pngfre_33,
            PizzaType.VEG),

        )
}
@Preview
@Composable
private fun PizzaSelectionScreenPreview(){
    PizzaSelectionScreen(){

    }
}