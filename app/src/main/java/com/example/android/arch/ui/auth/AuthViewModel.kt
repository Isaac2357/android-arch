package com.example.android.arch.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.android.arch.network.Resource
import com.example.android.arch.network.auth.AuthRepository
import com.example.android.arch.util.Status
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    var authRepository: AuthRepository
) : ViewModel() {

    init {
        Log.d("Dagger Log", "Auth View Model created using DI")
    }

    fun login(id: Int) = liveData(Dispatchers.IO, 5000) {
        emit(Resource(Status.LOADING, null, null))
        try {
            val user = authRepository.login(
                id = id
            )
            emit(Resource(Status.SUCCESS, user, null))
        } catch (e: Exception) {
            emit(Resource(Status.ERROR, null, e.message))
        }
    }

}