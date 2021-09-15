package com.example.daggerproject.network.auth

import com.example.daggerproject.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthService {

    @GET("users/{id}")
    suspend fun login(@Path("id") id: Int): User

}