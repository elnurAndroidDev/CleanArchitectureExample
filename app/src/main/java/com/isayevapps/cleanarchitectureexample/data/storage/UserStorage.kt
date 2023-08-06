package com.isayevapps.cleanarchitectureexample.data.storage

import com.isayevapps.cleanarchitectureexample.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}