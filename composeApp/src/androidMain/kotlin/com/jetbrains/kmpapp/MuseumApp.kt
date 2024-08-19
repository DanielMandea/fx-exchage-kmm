package com.jetbrains.kmpapp

import android.app.Application
import com.jetbrains.kmpapp.di.initKoin
import com.jetbrains.kmpapp.screens.museum.MuseumDetailViewModel
import com.jetbrains.kmpapp.screens.museum.MuseumListViewModel
import org.koin.dsl.module

class MuseumApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(
            listOf(
                module {
                    factory { MuseumListViewModel(get()) }
                    factory { MuseumDetailViewModel(get()) }
                }
            )
        )
    }
}
