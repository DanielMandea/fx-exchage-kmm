package com.jetbrains.kmpapp.di

import com.jetbrains.kmpapp.data.fx.FxApi
import com.jetbrains.kmpapp.data.fx.FxRepository
import com.jetbrains.kmpapp.data.fx.FxStorage
import com.jetbrains.kmpapp.data.fx.InMemoryFxStorage
import com.jetbrains.kmpapp.data.fx.KtorFxApi
import com.jetbrains.kmpapp.data.museum.InMemoryMuseumStorage
import com.jetbrains.kmpapp.data.museum.KtorMuseumApi
import com.jetbrains.kmpapp.data.museum.MuseumApi
import com.jetbrains.kmpapp.data.museum.MuseumRepository
import com.jetbrains.kmpapp.data.museum.MuseumStorage
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule = module {
    single {
        val json = Json { ignoreUnknownKeys = true }
        HttpClient {
            install(ContentNegotiation) {
                // TODO Fix API so it serves application/json
                json(json, contentType = ContentType.Any)
            }
        }
    }

    // Museum-related dependencies
    single<MuseumApi> { KtorMuseumApi(get()) }
    single<MuseumStorage> { InMemoryMuseumStorage() }
    single {
        MuseumRepository(get(), get()).apply {
            initialize()
        }
    }

    // Fx-related dependencies
    single<FxApi> { KtorFxApi(get()) } // Assuming KtorFxApi implements FxApi
    single<FxStorage> { InMemoryFxStorage() } // Assuming InMemoryFxStorage implements FxStorage
    single {
        FxRepository(get(), get()).apply {
            initialize()
        }
    }
}

fun initKoin() = initKoin(emptyList())

fun initKoin(extraModules: List<Module>) {
    startKoin {
        modules(
            dataModule,
            *extraModules.toTypedArray(),
        )
    }
}
