package com.sirius.test_app.di

import com.sirius.test_app.di.module.DomainModule
import com.sirius.test_app.ui.dota2.Dota2Fragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DomainModule::class])
interface AppComponent {
    fun inject(dota2Fragment: Dota2Fragment)
}