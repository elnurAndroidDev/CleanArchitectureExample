package com.isayevapps.cleanarchitectureexample.domain.usecases

import com.isayevapps.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.isayevapps.cleanarchitectureexample.domain.models.Source
import com.isayevapps.cleanarchitectureexample.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(params: SaveUserNameParam, source: Source): Boolean {
        return userRepository.saveData(params, source)
    }
}