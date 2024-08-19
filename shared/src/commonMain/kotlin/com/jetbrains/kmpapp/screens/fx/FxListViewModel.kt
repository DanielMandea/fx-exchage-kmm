package com.jetbrains.kmpapp.screens.fx

import com.jetbrains.kmpapp.data.fx.FxObject
import com.jetbrains.kmpapp.data.fx.FxRepository
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.stateIn
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

class FxListViewModel(fxRepository: FxRepository) : ViewModel() {
    @NativeCoroutinesState
    val objects: StateFlow<List<FxObject>> =
        fxRepository.getObjects()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
