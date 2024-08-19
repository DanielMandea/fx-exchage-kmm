package com.jetbrains.kmpapp

import com.jetbrains.kmpapp.data.fx.FxRepository
import com.jetbrains.kmpapp.data.museum.MuseumRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class KoinDependencies : KoinComponent {
    val museumRepository: MuseumRepository by inject()
    val fxRepository: FxRepository by inject()
}
