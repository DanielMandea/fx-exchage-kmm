package com.jetbrains.kmpapp.data.fx

import com.jetbrains.kmpapp.data.fx.FxObject

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import kotlin.coroutines.cancellation.CancellationException

interface FxApi {
    suspend fun getData(): List<FxObject>
}

class KtorFxApi(private val client: HttpClient) : FxApi {
    companion object {
        private const val API_URL = "https://fx.claimit.app/api/v1/fx/fetch/RON/range?to=EUR&dateStart=2024.06.01&dateEnd=2024.06.10"
        private const val TOKEN = "ZGFuaWVsLm1hbmRlYUBtdGR0ZWNobm9sb2d5Lm5ldERlbW8yMDI0LTA4LTE4IDAwOjAwOjAwICswMDAw"
    }

    override suspend fun getData(): List<FxObject> {
        return try {
            client.get(API_URL){
                headers {
                    append(HttpHeaders.Authorization, "Bearer $TOKEN")
                }
            }.body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()
            emptyList()
        }
    }
}