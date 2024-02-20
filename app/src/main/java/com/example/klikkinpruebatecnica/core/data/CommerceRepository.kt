package com.example.klikkinpruebatecnica.core.data

import com.example.klikkinpruebatecnica.core.data.models.CommerceBasic
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CommerceRepository(private val commerceAPI: CommerceAPI) {
    fun getCommerceList(): Flow<List<CommerceBasic>> =
        flow { emit(commerceAPI.getCommerceList()) }
}