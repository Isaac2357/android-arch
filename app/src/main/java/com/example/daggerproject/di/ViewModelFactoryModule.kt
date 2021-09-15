package com.example.daggerproject.di

import androidx.lifecycle.ViewModelProvider
import com.example.daggerproject.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelFactoryModule {
    /**
     * Similar to provides
     * DO NOT ADD SINGLETON ANNOTATION
     */
    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelProviderFactory
    ): ViewModelProvider.Factory
}