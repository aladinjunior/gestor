package com.aladinjunior.gestor.signin

import com.aladinjunior.gestor.signin.data.local.SignInFakeLocalDataSource
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