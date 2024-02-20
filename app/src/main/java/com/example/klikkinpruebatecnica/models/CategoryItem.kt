package com.example.klikkinpruebatecnica.models

import com.example.klikkinpruebatecnica.R

data class CategoryItem(
    val category: Int,
) {
    var image: Int = when(category){
        R.string.car_wash -> R.drawable.car_wash_colour
        R.string.catering -> R.drawable.catering_colour
        R.string.electric_scooter -> R.drawable.electric_scooter_colour
        R.string.shops -> R.drawable.cart_colour
        R.string.leisure -> R.drawable.leisure_colour
        R.string.parking -> R.drawable.parking_colour
        R.string.truck -> R.drawable.truck_colour
        R.string.parking_payment -> R.drawable.payment_regulated_parking_colour
        R.string.gas_station -> R.drawable.ees_colour
        else -> R.drawable.placeholder
    }
}

val categories = listOf<CategoryItem>(
    CategoryItem(R.string.car_wash),
    CategoryItem(R.string.shops),
    CategoryItem(R.string.catering),
    CategoryItem(R.string.gas_station),
    CategoryItem(R.string.electric_scooter),
    CategoryItem(R.string.leisure),
    CategoryItem(R.string.parking),
    CategoryItem(R.string.parking_payment),
    CategoryItem(R.string.truck),
    CategoryItem(R.string.others)
)