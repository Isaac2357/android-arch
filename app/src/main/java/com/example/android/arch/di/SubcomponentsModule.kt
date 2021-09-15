package com.example.android.arch.di

import com.example.android.arch.di.auth.AuthComponent
import dagger.Module

@Module(
    subcomponents = [
        AuthComponent::class
    ]
)
object SubcomponentsModule