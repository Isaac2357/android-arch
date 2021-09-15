package com.example.android.arch.di

import androidx.lifecycle.ViewModelProvider
import com.example.android.arch.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

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