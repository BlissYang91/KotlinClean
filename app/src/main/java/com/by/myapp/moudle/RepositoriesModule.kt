package com.by.myapp.moudle

import com.by.myapp.repository.MainRepository
import com.by.myapp.repository.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoriesModule {
    @Binds
    fun mainRepository(mainRepositoryImpl: MainRepositoryImpl) : MainRepository
}