package com.jetbrains.kmpapp.screens.museum

import com.jetbrains.kmpapp.`data`.museum.MuseumObject
import com.rickclephas.kmp.nativecoroutines.NativeFlow
import com.rickclephas.kmp.nativecoroutines.asNativeFlow
import kotlin.collections.List
import kotlin.native.ObjCName

public val MuseumListViewModel.objectsFlow: NativeFlow<List<MuseumObject>>
  get() = objects.asNativeFlow(null)

@ObjCName(name = "objects")
public val MuseumListViewModel.objectsValue: List<MuseumObject>
  get() = objects.value
