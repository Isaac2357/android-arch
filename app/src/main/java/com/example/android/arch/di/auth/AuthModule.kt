package com.example.android.arch.di.auth

import com.example.android.arch.di.ActivityScope
import com.example.android.arch.network.auth.AuthRepository
import com.example.android.arch.network.auth.AuthService
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