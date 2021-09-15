package com.example.daggerproject.di.auth

import androidx.lifecycle.ViewModel
import com.example.daggerproject.di.ActivityScope
import com.example.daggerproject.di.ViewModelKey
import com.example.daggerproject.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Responsible for injection Auth View Model
 */
@Module
abstract class AuthViewModelModule {

    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel: AuthViewModel): ViewModel

}