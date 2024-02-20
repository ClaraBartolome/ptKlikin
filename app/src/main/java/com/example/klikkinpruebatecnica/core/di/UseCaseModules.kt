package com.example.klikkinpruebatecnica.core.di

import com.example.klikkinpruebatecnica.core.data.CommerceRepository
import com.example.klikkinpruebatecnica.useCases.GetCommerceUseBaseCase
import com.example.klikkinpruebatecnica.useCases.GetCommercesUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCasesModule = module {
    single(named("get_commerces")) { provideGetCommerces(get()) as GetCommercesUseCase}
}

fun provideGetCommerces(repository: CommerceRepository): GetCommerceUseBaseCase {
    return GetCommercesUseCase(repository)
}