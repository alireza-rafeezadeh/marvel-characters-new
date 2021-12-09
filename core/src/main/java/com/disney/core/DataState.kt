package com.disney.core

sealed class DataState<T>

data class Response<T>(val uiComponent: UiComponent) : DataState<T>()

data class Data<T>(val data: T? = null) : DataState<T>()

data class Loading<T>(val progressBar: ProgressBarState) : DataState<T>()


