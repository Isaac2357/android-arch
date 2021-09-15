package com.example.daggerproject.di.auth

import com.example.daggerproject.di.ActivityScope
import com.example.daggerproject.network.auth.AuthRepository
import com.example.daggerproject.network.auth.AuthService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object AuthModule {

    @ActivityScope
    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @ActivityScope
    @Provides
    fun provideAuthRepo(authService: AuthService): AuthRepository = AuthRepository(authService)

}