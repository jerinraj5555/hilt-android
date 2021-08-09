package com.example.hiltandroid.module

import com.example.hiltandroid.data.MainRepository
import com.example.hiltandroid.data.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
//List all API related impl
interface RepositoriesModule {

    @Binds
    fun mainRepository(mainRepositoryImpl: MainRepositoryImpl) : MainRepository
}