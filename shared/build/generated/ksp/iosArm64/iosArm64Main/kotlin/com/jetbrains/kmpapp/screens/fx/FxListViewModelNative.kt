package com.jetbrains.kmpapp.screens.fx

import com.jetbrains.kmpapp.`data`.fx.FxObject
import com.rickclephas.kmp.nativecoroutines.NativeFlow
import com.rickclephas.kmp.nativecoroutines.asNativeFlow
import kotlin.collections.List
import kotlin.native.ObjCName

public val FxListViewModel.objectsFlow: NativeFlow<List<FxObject>>
  get() = objects.asNativeFlow(null)

@ObjCName(name = "objects")
public val FxListViewModel.objectsValue: List<FxObject>
  get() = objects.value
