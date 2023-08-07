package com.isayevapps.cleanarchitectureexample.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.isayevapps.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.isayevapps.cleanarchitectureexample.data.storage.SharedPrefUserStorage
import com.isayevapps.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.isayevapps.cleanarchitectureexample.domain.usecases.GetUserNameUseCase
import com.isayevapps.cleanarchitectureexample.domain.usecases.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val _nameLive = MutableLiveData<String>()
    val nameLive: LiveData<String> = _nameLive

    fun save(name: String) {
        val params = SaveUserNameParam(name = name)
        val saved = saveUserNameUseCase.execute(params)
        _nameLive.value = "Saved: $saved"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        _nameLive.value = "${userName.firstName} ${userName.lastName}"
    }

}