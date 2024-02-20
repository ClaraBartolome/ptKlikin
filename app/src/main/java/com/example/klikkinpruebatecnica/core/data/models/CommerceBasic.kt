package com.example.klikkinpruebatecnica.core.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CommerceBasic(
    @Expose @SerializedName("photo") val photo:  String? = null,
    @Expose @SerializedName("name") val name:  String? = null,
    @Expose @SerializedName("category") val category:  String? = null,
    @Expose @SerializedName("cashback") val cashback: Double? = null,
    @Expose @SerializedName("location") val location: ArrayList<Double> = arrayListOf(),
    @Expose @SerializedName("openingHours") val openingHours:  String? = null,
    @Expose @SerializedName("address") val address: AdressBasic? = AdressBasic()
)