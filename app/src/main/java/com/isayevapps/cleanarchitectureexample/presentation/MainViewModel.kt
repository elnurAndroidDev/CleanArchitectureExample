package com.isayevapps.cleanarchitectureexample.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isayevapps.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.isayevapps.cleanarchitectureexample.domain.models.Source
import com.isayevapps.cleanarchitectureexample.domain.usecases.GetUserNameUseCase
import com.isayevapps.cleanarchitectureexample.domain.usecases.SaveUserNameUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val _nameLive = MutableLiveData<String>()
    val nameLive: LiveData<String> = _nameLive

    private var source: Source = Source.CLOUD

    /*fun changeSource(isLocal: Boolean) {
        source = if (isLocal)
            Source.LOCAL
        else
            Source.CLOUD
    }*/

    fun save(name: String) {
        val params = SaveUserNameParam(name = name)
        val saved = saveUserNameUseCase.execute(params, source)
        _nameLive.value = "Saved: $saved"
    }

    fun load() = viewModelScope.launch {
        val userName = getUserNameUseCase.execute(source)
        _nameLive.value = "${userName.firstName} ${userName.lastName}"
    }

}