package com.example.artisan.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.artisan.domain.usecase.ArtisanUseCase

class LoginViewModel(useCase: ArtisanUseCase) : ViewModel()  {


    private val _isValid = MutableLiveData<Boolean>()
    val isValid: LiveData<Boolean>
        get() = _isValid


    fun onClickLogin(username : String, password : String){
        if (username.isEmpty() || password.isEmpty()){
            _isValid.value = false
            return
        }
        _isValid.value = true


    }
}