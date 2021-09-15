package com.example.android.arch.network.auth

import com.example.android.arch.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthService {

    @GET("users/{id}")
    suspend fun login(@Path("id") id: Int): User

}