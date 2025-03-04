package com.example.test_idea_platform.presentation.di

import com.example.test_idea_platform.domain.DeviceRepository
import com.example.test_idea_platform.domain.interacror.Interactor
import com.example.test_idea_platform.domain.interacror.InteractorImpl
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {
    @Provides
    fun provideDeviceInteractor(deviceRepository: DeviceRepository): Interactor {
        return InteractorImpl(deviceRepository)
    }
}