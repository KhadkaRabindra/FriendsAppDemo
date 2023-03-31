package com.example.friends.di

import com.example.friends.domain.repository.UserRepository
import com.example.friends.domain.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepository(facrRepositoryImpl: UserRepositoryImpl): UserRepository
}