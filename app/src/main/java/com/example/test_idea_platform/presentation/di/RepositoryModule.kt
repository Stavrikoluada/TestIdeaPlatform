package com.example.test_idea_platform.presentation.di

import com.example.test_idea_platform.data.DeviceRepositoryImpl
import com.example.test_idea_platform.domain.DeviceRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideDeviceRepository(): DeviceRepository {
        return DeviceRepositoryImpl()
    }
}