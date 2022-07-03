package com.by.domain.common

interface Callback<in R> {
    fun onSuccess(result: R)
    fun onError(throwable: Throwable)
}