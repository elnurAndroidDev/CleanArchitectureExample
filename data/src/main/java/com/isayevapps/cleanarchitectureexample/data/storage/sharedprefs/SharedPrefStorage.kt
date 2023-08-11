package com.isayevapps.cleanarchitectureexample.data.storage.sharedprefs

import com.isayevapps.cleanarchitectureexample.data.storage.models.User

interface SharedPrefStorage {

    fun save(user: User): Boolean

    fun get(): User

}