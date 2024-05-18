package com.aladinjunior.gestor.di

import com.aladinjunior.gestor.people.data.repository.FakePeopleRepository
import com.aladinjunior.gestor.people.data.repository.PeopleRepository
import com.aladinjunior.gestor.signin.data.repository.FakeUserRepository
import com.aladinjunior.gestor.signin.data.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {


    @Binds
    internal abstract fun bindsPeopleRepository(
        peopleRepository: FakePeopleRepository
    ) : PeopleRepository

    @Binds
    internal abstract fun bindsSignInRepository(
        userRepository: FakeUserRepository
    ) : UserRepository

}