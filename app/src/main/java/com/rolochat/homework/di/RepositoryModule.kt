package com.rolochat.homework.di

import com.rolochat.homework.model.api.ApiService
import com.rolochat.homework.model.repository.RoloDbRepository
import com.rolochat.homework.model.repository.RoloRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    fun provideRoloRepository(apiService: ApiService, dbRepository: RoloDbRepository): RoloRepository {
        return RoloRepository(apiService, dbRepository)
    }
}