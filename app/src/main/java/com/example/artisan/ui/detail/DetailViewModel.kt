package com.example.artisan.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.artisan.domain.usecase.ArtisanUseCase

class DetailViewModel(private val artisanUseCase: ArtisanUseCase) : ViewModel() {

    fun getArtisanById(artisanId : String) = artisanUseCase.getArtisanById(artisanId).asLiveData()
}