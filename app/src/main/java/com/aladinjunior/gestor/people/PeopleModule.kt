package com.aladinjunior.gestor.people

import com.aladinjunior.gestor.people.data.local.PeopleFakeLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PeopleModule {

    @Provides
    @Singleton
    fun providePeopleFakeLocalDataSource(): PeopleFakeLocalDataSource {
        return PeopleFakeLocalDataSource
    }
}