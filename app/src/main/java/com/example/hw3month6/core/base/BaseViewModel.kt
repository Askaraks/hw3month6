package com.example.hw3month6.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    val loading = MutableLiveData<Boolean>()
}