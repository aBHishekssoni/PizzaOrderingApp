package com.example.pizzaorderingapp
enum class PizzaType {
    VEG, NonVeg,
}
data class Pizza(
    val name: String,
    val price: Double,
    val image: Int,
    val pizzaType: PizzaType,
)
data class Topping(
    val title: String,
    val price: Double,
    var isChecked: Boolean = false,
)
    fun dummyToppingList(): List<Topping> {
        return listOf(
            Topping(
                "Onion",
                10.00
            ),
            Topping(
                "Mushroom",
                20.00
            ),
            Topping(
                "Tomato",
                10.00),
            Topping(
                "Pepper",10.00,),
            Topping(
                "Paneer",10.00),
            Topping(
                "Capcicum",10.00),
            Topping(
                "Olive",10.00),
            Topping(
                "Corn",10.00),
            Topping(
                "Extra Cheese",20.00),
            Topping(
                "Extra Onion",10.00),
            Topping(
                "Extra Mushroom",10.00),
            Topping(
                "Extra Tomato",10.00),
            Topping(
                "Extra Capcicum",10.00),
            Topping(
                "Extra Olive",10.00),
            Topping(
                "Extra Corn",10.00),
            Topping(
                "Extra Paneer",10.00),
            Topping(
                "Pepperoni",20.00)

        )

    }

fun dummyPizzaList(): List<Pizza> {
    return listOf(
        Pizza(
        "Pepperoni",
        100.00,
        R.drawable.pizza,
        PizzaType.NonVeg),
        Pizza(
        "Margherita",
        150.00,
        R.drawable.pizza_png_from_pngfre_33,
        PizzaType.VEG),
        Pizza(
            "Vegetarian",
        200.00,
        R.drawable.pizza_png_pepperoni_pizza_1000,
        PizzaType.VEG
        ),
        Pizza(
            "BBQ Chicken",
        250.00,
        R.drawable.pizza_png_pizza_png_image_3505,
        PizzaType.NonVeg),
        Pizza(
            "BBQ Chicken Deluxe",
        300.00,
        R.drawable.pizza,
        PizzaType.NonVeg),

    )
}
