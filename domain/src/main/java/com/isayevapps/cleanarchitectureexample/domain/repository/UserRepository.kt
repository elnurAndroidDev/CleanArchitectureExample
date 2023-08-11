package com.isayevapps.cleanarchitectureexample.domain.repository

import com.isayevapps.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.isayevapps.cleanarchitectureexample.domain.models.Source
import com.isayevapps.cleanarchitectureexample.domain.models.UserName

interface UserRepository {
    fun saveData(data: SaveUserNameParam, source: Source): Boolean
    suspend fun getData(source: Source): UserName
}