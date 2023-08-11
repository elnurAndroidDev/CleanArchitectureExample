package com.isayevapps.cleanarchitectureexample.di

import com.isayevapps.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.isayevapps.cleanarchitectureexample.data.storage.firebase.FireBaseStorage
import com.isayevapps.cleanarchitectureexample.data.storage.firebase.FireBaseStorageImpl
import com.isayevapps.cleanarchitectureexample.data.storage.sharedprefs.SharedPrefStorage
import com.isayevapps.cleanarchitectureexample.data.storage.sharedprefs.SharedPrefStorageImpl
import com.isayevapps.cleanarchitectureexample.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<SharedPrefStorage> {
        SharedPrefStorageImpl(context = get())
    }

    single<FireBaseStorage> {
        FireBaseStorageImpl()
    }

    single<UserRepository> {
        UserRepositoryImpl(localStorage = get(), cloudStorage = get())
    }

}