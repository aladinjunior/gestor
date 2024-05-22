package com.aladinjunior.gestor.di

import com.aladinjunior.gestor.feature.signin.data.local.SignInFakeLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SignInModule {

    @Provides
    @Singleton
    fun provideSignInFakeLocalDataSource() : SignInFakeLocalDataSource {
        return SignInFakeLocalDataSource
    }
}