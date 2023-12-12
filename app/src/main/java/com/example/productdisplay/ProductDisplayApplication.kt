package com.example.productdisplay

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ProductDisplayApplication: Application() {
    override fun onCreate() {
    super.onCreate()
    }
}