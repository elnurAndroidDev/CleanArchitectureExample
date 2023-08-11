package com.isayevapps.cleanarchitectureexample.data.storage.firebase

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.isayevapps.cleanarchitectureexample.data.storage.models.User
import kotlinx.coroutines.tasks.await

class FireBaseStorageImpl : FireBaseStorage {

    private val database = Firebase.database.reference

    override fun write(data: String): Boolean {
        database.setValue(data)
        return true
    }

    override suspend fun read(): User {
        val name = database.get().await().value as String
        return User(name, "")
    }
}