package com.jetbrains.kmpapp.data.fx

import com.jetbrains.kmpapp.data.fx.FxObject

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

interface FxStorage {
    suspend fun saveObjects(newObjects: List<FxObject>)

    fun getObjectById(objectId: String): Flow<FxObject?>

    fun getObjects(): Flow<List<FxObject>>
}

class InMemoryFxStorage : FxStorage {
    private val storedObjects = MutableStateFlow(emptyList<FxObject>())

    override suspend fun saveObjects(newObjects: List<FxObject>) {
        storedObjects.value = newObjects
    }

    override fun getObjectById(objectId: String): Flow<FxObject?> {
        return storedObjects.map { objects ->
            objects.find { it.id == objectId }
        }
    }

    override fun getObjects(): Flow<List<FxObject>> = storedObjects
}
