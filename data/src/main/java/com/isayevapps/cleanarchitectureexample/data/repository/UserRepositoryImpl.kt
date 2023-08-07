package com.isayevapps.cleanarchitectureexample.data.repository

import com.isayevapps.cleanarchitectureexample.data.storage.models.User
import com.isayevapps.cleanarchitectureexample.data.storage.UserStorage
import com.isayevapps.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.isayevapps.cleanarchitectureexample.domain.models.UserName
import com.isayevapps.cleanarchitectureexample.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {


    override fun saveData(data: SaveUserNameParam): Boolean {
        val user = User(data.name, "")
        return userStorage.save(user)
    }

    override fun getData(): UserName {
        val user = userStorage.get()
        val userName = UserName(user.firstName, user.lastName)
        return userName
    }
}