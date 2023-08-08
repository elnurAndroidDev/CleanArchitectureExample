package com.isayevapps.cleanarchitectureexample.di

import com.isayevapps.cleanarchitectureexample.domain.usecases.GetUserNameUseCase
import com.isayevapps.cleanarchitectureexample.domain.usecases.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}