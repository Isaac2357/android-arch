package com.example.daggerproject.network

import com.example.daggerproject.util.Status.ERROR as ERROR
import com.example.daggerproject.util.Status.SUCCESS as SUCCESS
import com.example.daggerproject.util.Status.LOADING as LOADING
import com.example.daggerproject.util.Status

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): Resource<T> =
            Resource(status = ERROR, data = data, message = message)

        fun <T> loading(data: T?): Resource<T> = Resource(status = LOADING, data = data, message = null)
    }
}
