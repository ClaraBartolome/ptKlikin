package com.example.klikkinpruebatecnica.core.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AdressBasic(
    @Expose @SerializedName("street") val street: String? = null,
    @Expose @SerializedName("city") val city: String? = null,
    @Expose @SerializedName("state") val state: String? = null,
    @Expose @SerializedName("zip") val zip: String? = null,
    @Expose @SerializedName("country") val country: String? = null,
)