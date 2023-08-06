package com.isayevapps.cleanarchitectureexample.domain.usecases

import com.isayevapps.cleanarchitectureexample.domain.models.UserName
import com.isayevapps.cleanarchitectureexample.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getData()
    }
}