package com.jetbrains.kmpapp.screens.fx

import com.jetbrains.kmpapp.`data`.fx.FxObject
import com.rickclephas.kmp.nativecoroutines.NativeFlow
import com.rickclephas.kmp.nativecoroutines.asNativeFlow
import kotlin.OptIn
import kotlin.native.ObjCName
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
public val FxDetailViewModel.museumObjectFlow: NativeFlow<FxObject?>
  get() = museumObject.asNativeFlow(null)

@OptIn(ExperimentalCoroutinesApi::class)
@ObjCName(name = "museumObject")
public val FxDetailViewModel.museumObjectValue: FxObject?
  get() = museumObject.value
