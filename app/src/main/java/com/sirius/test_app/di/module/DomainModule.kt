package com.sirius.test_app.di.module

import com.sirius.test_app.data.repository.Dota2RepositoryImpl
import com.sirius.test_app.domain.repository.Dota2Repository
import com.sirius.test_app.domain.usecase.GetDataDota2UseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface DomainModule {

    companion object {
        @Singleton
        @Provides
        fun provideGetDataDota2UseCase(repository: Dota2Repository): GetDataDota2UseCase =
            GetDataDota2UseCase(repository)

    }

    @Singleton
    @Binds
    fun bindDota2Repository(impl: Dota2RepositoryImpl): Dota2Repository

}