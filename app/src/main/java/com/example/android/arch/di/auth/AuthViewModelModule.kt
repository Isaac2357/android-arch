package com.example.android.arch.di.auth

import androidx.lifecycle.ViewModel
import com.example.android.arch.di.ActivityScope
import com.example.android.arch.di.ViewModelKey
import com.example.android.arch.ui.auth.AuthViewModel
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