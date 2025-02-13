package com.example.training.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//This is the first step in implementing hilt for DI
// https://developer.android.com/training/dependency-injection/hilt-android
@HiltAndroidApp
class ValidationApplication: Application()