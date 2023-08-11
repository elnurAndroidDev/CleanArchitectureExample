package com.isayevapps.cleanarchitectureexample.data.storage.firebase

import com.isayevapps.cleanarchitectureexample.data.storage.models.User

interface FireBaseStorage {

    fun write(data: String): Boolean

    suspend fun read(): User
}