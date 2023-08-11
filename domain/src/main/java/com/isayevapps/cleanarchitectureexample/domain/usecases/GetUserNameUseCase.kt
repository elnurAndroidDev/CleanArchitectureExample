package com.isayevapps.cleanarchitectureexample.domain.usecases

import com.isayevapps.cleanarchitectureexample.domain.models.Source
import com.isayevapps.cleanarchitectureexample.domain.models.UserName
import com.isayevapps.cleanarchitectureexample.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    suspend fun execute(source: Source): UserName {
        return userRepository.getData(source)
    }
}