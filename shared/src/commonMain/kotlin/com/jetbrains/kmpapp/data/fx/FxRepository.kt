package com.jetbrains.kmpapp.data.fx

import com.jetbrains.kmpapp.data.fx.FxApi
import com.jetbrains.kmpapp.data.fx.FxObject
import com.jetbrains.kmpapp.data.fx.FxStorage


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FxRepository(
    private val fxApi: FxApi,
    private val fxStorage: FxStorage,
) {
    private val scope = CoroutineScope(SupervisorJob())

    fun initialize() {
        scope.launch {
            refresh()
        }
    }

    private suspend fun refresh() {
        fxStorage.saveObjects(fxApi.getData())
    }

    fun getObjects(): Flow<List<FxObject>> = fxStorage.getObjects()

    fun getObjectById(objectId: String): Flow<FxObject?> = fxStorage.getObjectById(objectId)
}
