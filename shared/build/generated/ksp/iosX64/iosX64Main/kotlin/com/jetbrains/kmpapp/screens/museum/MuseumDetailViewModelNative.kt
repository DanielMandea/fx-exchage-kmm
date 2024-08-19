package com.jetbrains.kmpapp.screens.museum

import com.jetbrains.kmpapp.`data`.museum.MuseumObject
import com.rickclephas.kmp.nativecoroutines.NativeFlow
import com.rickclephas.kmp.nativecoroutines.asNativeFlow
import kotlin.OptIn
import kotlin.native.ObjCName
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
public val MuseumDetailViewModel.museumObjectFlow: NativeFlow<MuseumObject?>
  get() = museumObject.asNativeFlow(null)

@OptIn(ExperimentalCoroutinesApi::class)
@ObjCName(name = "museumObject")
public val MuseumDetailViewModel.museumObjectValue: MuseumObject?
  get() = museumObject.value
