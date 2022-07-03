package com.by.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(){
    private val progressBarStatus = MutableLiveData<Boolean>()

    fun getProgressBarStatus() : MutableLiveData<Boolean> {
        return progressBarStatus
    }

}