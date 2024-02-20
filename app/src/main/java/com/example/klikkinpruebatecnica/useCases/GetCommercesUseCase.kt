package com.example.klikkinpruebatecnica.useCases

import com.example.klikkinpruebatecnica.core.data.CommerceRepository
import com.example.klikkinpruebatecnica.core.data.models.CommerceBasic
import kotlinx.coroutines.flow.Flow

typealias GetCommerceUseBaseCase = BaseUseCase<Unit, Flow<List<CommerceBasic>>>

class GetCommercesUseCase (private val repository: CommerceRepository): GetCommerceUseBaseCase {
    override suspend fun invoke(params: Unit) = repository.getCommerceList()
}