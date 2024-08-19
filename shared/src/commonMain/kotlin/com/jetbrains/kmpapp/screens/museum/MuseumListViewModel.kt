package com.jetbrains.kmpapp.screens.museum

import com.jetbrains.kmpapp.data.museum.MuseumObject
import com.jetbrains.kmpapp.data.museum.MuseumRepository
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.stateIn
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

class MuseumListViewModel(museumRepository: MuseumRepository) : ViewModel() {
    @NativeCoroutinesState
    val objects: StateFlow<List<MuseumObject>> =
        museumRepository.getObjects()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
