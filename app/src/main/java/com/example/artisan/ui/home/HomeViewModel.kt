package com.example.artisan.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.artisan.domain.usecase.ArtisanUseCase

class HomeViewModel(artisanUseCase: ArtisanUseCase) : ViewModel() {

    val artisan = artisanUseCase.getAllArtisan().asLiveData()
}