package com.example.klikkinpruebatecnica.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.klikkinpruebatecnica.core.data.models.CommerceBasic
import com.example.klikkinpruebatecnica.core.utils.BaseViewModel
import com.example.klikkinpruebatecnica.presentation.models.LoadingState
import com.example.klikkinpruebatecnica.useCases.GetCommercesUseCase
import com.example.proyecto2.utils.DispatcherFactory
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragmentViewModel(
    private val dispatcherFactory: DispatcherFactory,
    private val getCommercesUseCase: GetCommercesUseCase
    ) : BaseViewModel(dispatcherFactory) {

    companion object {
        const val LOAD_ERROR = "load error"
    }

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState
    private val _commerceList = MutableLiveData<List<CommerceBasic>>()
    val commerceList: LiveData<List<CommerceBasic>>
        get() = _commerceList

    fun getCommerces() {
        launch {
            withContext(dispatcherFactory.getIO()) {
                getCommercesUseCase(Unit).onStart { _loadingState.postValue(LoadingState.LOADING) }
                    .catch {
                        _loadingState.postValue(
                            LoadingState.error(LOAD_ERROR)
                        )
                        Log.e("FAIL:", it.message.toString())

                    }
                    .collect {
                        _commerceList.postValue(it)
                        _loadingState.postValue(LoadingState.LOADED)
                        Log.d("LOADED:", "${it.size}")
                    }
            }
        }
    }
}