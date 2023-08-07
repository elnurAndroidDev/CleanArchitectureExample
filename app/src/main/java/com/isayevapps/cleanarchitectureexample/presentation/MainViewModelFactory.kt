package com.isayevapps.cleanarchitectureexample.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.isayevapps.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.isayevapps.cleanarchitectureexample.data.storage.SharedPrefUserStorage
import com.isayevapps.cleanarchitectureexample.domain.usecases.GetUserNameUseCase
import com.isayevapps.cleanarchitectureexample.domain.usecases.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val userRepository by lazy { UserRepositoryImpl(SharedPrefUserStorage(context)) }
    private val saveUserNameUseCase by lazy {
        SaveUserNameUseCase(
            userRepository
        )
    }
    private val getUserNameUseCase by lazy {
        GetUserNameUseCase(
            userRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}