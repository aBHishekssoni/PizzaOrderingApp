package com.example.pizzaorderingapp.ui.screen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaorderingapp.Topping
import com.example.pizzaorderingapp.dummyPizzaList
import com.example.pizzaorderingapp.dummyToppingList

@Composable
fun ToppingSelection(
    modifier: Modifier = Modifier,
    pizzaid: Int,
    onConfirm: (Int,Set<Topping>) -> Unit,
) {
    val pizza = dummyPizzaList()[pizzaid]
    var SelectedTopping by remember { mutableStateOf(emptySet<Topping>()) }

    var selectedcheckbox by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground)
    ) {
        Column {
            Spacer(modifier = Modifier.padding(12.dp))

            Text(
                text = "Select Topping",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(8.dp), color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = "${pizza.name} selected", modifier = Modifier.padding(8.dp),
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.padding(8.dp))

            LazyColumn(
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {


                items(dummyToppingList()) {
                    ToppingsItem(toppings = it){selection->
                        if (selection.isChecked) {
                           SelectedTopping=  SelectedTopping.plusElement(selection)
                        } else {
                            SelectedTopping = SelectedTopping.minusElement(selection)
                        }
                        Log.d("checkbox value","$SelectedTopping")
//                        SelectedTopping.toMutableList().add(selection)
                    }

                }

            }
        }
        FloatingActionButton(
            onClick = { onConfirm(pizzaid,SelectedTopping) },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            shape = MaterialTheme.shapes.extraLarge,
            containerColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(imageVector = Icons.Default.Done, contentDescription = "Done")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ToppingsItem(
    modifier: Modifier = Modifier,
    toppings: Topping,
    ontoppingselected: (Topping) -> Unit

) {
    var selectedcheckbox by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Checkbox(checked = selectedcheckbox, onCheckedChange = { Log.d("checkbox value","$it")
            selectedcheckbox = it
            toppings.isChecked = selectedcheckbox
            ontoppingselected(toppings)

            })
//            Column(
//                modifier
//                    .height(100.dp)
//                    .weight(1f)
//                    .padding(16.dp),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally

//            )
//            {
            Text(
                text = toppings.title,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .basicMarquee()
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Rs ${toppings.price}",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Blue.copy(alpha = .6f),
                modifier = Modifier.padding(10.dp)

            )
//            }

        }

    }


}

@Preview
@Composable
private fun ToppingsItemPreview() {
    ToppingsItem(
        toppings = Topping(
            "Pepper", 10.00,
        )
    ){}

}

@Preview
@Composable
private fun ToppingSelectionPreview() {
    ToppingSelection( pizzaid = 0){
        _,_->
    }
}