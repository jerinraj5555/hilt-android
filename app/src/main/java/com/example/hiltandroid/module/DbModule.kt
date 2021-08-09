package com.example.hiltandroid.module

import com.example.hiltandroid.repo.LocalRepo
import com.example.hiltandroid.repo.LocalRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
//List db related impl
interface DbModule {
    @Binds
    fun provideLocalDb(localRepoImpl: LocalRepoImpl):LocalRepo
}