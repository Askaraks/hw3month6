package com.example.hw3month6

import android.app.Application
import com.example.hw3month6.repository.Repository

class App : Application() {

    companion object{
        val repository = Repository()

    }

}