package com.example.artisan.domain.usecase

import com.example.artisan.domain.model.Artisan
import com.example.artisan.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ArtisanUseCase {

    fun getAllArtisan() : Flow<Resource<List<Artisan>>>
    fun getArtisanById(artisanId : String) : Flow<Resource<Artisan>>
}