package com.example.daggerproject.network.auth

import javax.inject.Inject


class AuthRepository @Inject constructor(
    private val authService: AuthService
) {
    suspend fun login(id: Int) = authService.login(
        id = id
    )
}