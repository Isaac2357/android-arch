package com.example.daggerproject.di

import com.example.daggerproject.di.auth.AuthComponent
import dagger.Module

@Module(
    subcomponents = [
        AuthComponent::class
    ]
)
object SubcomponentsModule