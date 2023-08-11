package com.isayevapps.cleanarchitectureexample.data.repository

import com.isayevapps.cleanarchitectureexample.data.storage.firebase.FireBaseStorage
import com.isayevapps.cleanarchitectureexample.data.storage.models.User
import com.isayevapps.cleanarchitectureexample.data.storage.sharedprefs.SharedPrefStorage
import com.isayevapps.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.isayevapps.cleanarchitectureexample.domain.models.Source
import com.isayevapps.cleanarchitectureexample.domain.models.UserName
import com.isayevapps.cleanarchitectureexample.domain.repository.UserRepository

class UserRepositoryImpl(private val localStorage: SharedPrefStorage, private val cloudStorage: FireBaseStorage) : UserRepository {


    override fun saveData(data: SaveUserNameParam, source: Source): Boolean {
        val user = User(data.name, "")
        return if (source == Source.LOCAL)
            localStorage.save(user)
        else
            cloudStorage.write(data.name)
    }

    override suspend fun getData(source: Source): UserName {
        val user = if (source == Source.LOCAL) localStorage.get() else cloudStorage.read()
        val userName = UserName(user.firstName, user.lastName)
        return userName
    }
}