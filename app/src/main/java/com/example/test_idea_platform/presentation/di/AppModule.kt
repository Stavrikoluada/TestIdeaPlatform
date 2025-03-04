package com.example.test_idea_platform.presentation.di

import com.example.test_idea_platform.domain.interacror.Interactor
import com.example.test_idea_platform.presentation.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideMainViewModel(deviceInteractor: Interactor): MainViewModel {
        return MainViewModel(deviceInteractor)
    }
}