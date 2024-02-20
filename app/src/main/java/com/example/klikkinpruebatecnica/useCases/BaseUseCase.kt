package com.example.klikkinpruebatecnica.useCases

interface BaseUseCase<in Parameter, out Result> {
    suspend operator fun invoke(params: Parameter): Result
}