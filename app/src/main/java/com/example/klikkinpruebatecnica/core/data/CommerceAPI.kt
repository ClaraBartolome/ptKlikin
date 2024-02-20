package com.example.klikkinpruebatecnica.core.data

import com.example.klikkinpruebatecnica.core.data.models.CommerceBasic
import retrofit2.http.GET
import retrofit2.http.Query

interface CommerceAPI {
    @GET("commerces.json")
    suspend fun getCommerceList(
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 10,
    ): List<CommerceBasic>
}