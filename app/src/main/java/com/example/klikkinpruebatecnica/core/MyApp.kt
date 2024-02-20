package com.example.klikkinpruebatecnica.core

import android.app.Application
import com.example.klikkinpruebatecnica.core.di.commerceAPIModule
import com.example.klikkinpruebatecnica.core.di.dispatcherFactoryModule
import com.example.klikkinpruebatecnica.core.di.netModule
import com.example.klikkinpruebatecnica.core.di.repositoryModule
import com.example.klikkinpruebatecnica.core.di.useCasesModule
import com.example.klikkinpruebatecnica.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApp)
            modules(
                listOf(
                    dispatcherFactoryModule,
                    netModule,
                    viewModelModule,
                    useCasesModule,
                    commerceAPIModule,
                    repositoryModule,
                )
            )
        }
    }
}