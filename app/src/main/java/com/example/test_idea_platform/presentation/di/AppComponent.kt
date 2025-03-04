package com.example.test_idea_platform.presentation.di

import com.example.test_idea_platform.presentation.MainActivity
import dagger.Component
import jakarta.inject.Singleton

@Component(modules = [AppModule::class, RepositoryModule::class, InteractorModule::class])
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}