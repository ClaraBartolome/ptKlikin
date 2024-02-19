package com.example.klikkinpruebatecnica.core

import com.example.klikkinpruebatecnica.presentation.home.HomeFragmentViewModel
import dagger.Component

@Component
interface MyApp {
    fun homeFragmentViewModel(): HomeFragmentViewModel
}