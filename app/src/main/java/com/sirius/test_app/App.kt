package com.sirius.test_app

import android.app.Application
import com.sirius.test_app.di.DaggerAppComponent

class App : Application() {
    val appComponent = DaggerAppComponent.create()
}