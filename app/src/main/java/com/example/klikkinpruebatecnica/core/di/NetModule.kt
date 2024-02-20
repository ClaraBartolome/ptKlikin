package com.example.klikkinpruebatecnica.core.di

import android.app.Application
import com.example.klikkinpruebatecnica.core.common.BASE_URL
import com.example.klikkinpruebatecnica.core.data.CommerceAPI
import com.example.klikkinpruebatecnica.core.data.CommerceRepository
import com.example.klikkinpruebatecnica.presentation.home.HomeFragmentViewModel
import com.example.proyecto2.utils.AppDispatcherFactory
import com.example.proyecto2.utils.DispatcherFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule: Module = module {
    viewModel {
        HomeFragmentViewModel( get(),
            getCommercesUseCase = get(named("get_commerces"))
        )
    }
}

val dispatcherFactoryModule = module {
    single<DispatcherFactory> {
        AppDispatcherFactory()
    }
}

val netModule: Module = module {

    fun provideCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    fun provideHttpClient(cache: Cache): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .cache(cache)

        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
    }


    single {
        provideHttpClient(get())
    }

    single { provideCache(androidApplication()) }

    single {
        provideRetrofit(get())
    }

}

val commerceAPIModule: Module = module {
    fun provideCommerceApi(retrofit: Retrofit): CommerceAPI {
        return retrofit.create(CommerceAPI::class.java)
    }

    single {
        provideCommerceApi(get())
    }

}

val repositoryModule = module {
    single {
        CommerceRepository(get())
    }
}
