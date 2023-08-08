package com.isayevapps.cleanarchitectureexample.di

import com.isayevapps.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.isayevapps.cleanarchitectureexample.data.storage.SharedPrefUserStorage
import com.isayevapps.cleanarchitectureexample.data.storage.UserStorage
import com.isayevapps.cleanarchitectureexample.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}