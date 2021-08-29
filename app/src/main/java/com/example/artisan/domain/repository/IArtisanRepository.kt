package com.example.artisan.domain.repository

import com.example.artisan.domain.model.Artisan
import com.example.artisan.utils.Resource
import kotlinx.coroutines.flow.Flow

interface IArtisanRepository {

    fun getAllArtisan() : Flow<Resource<List<Artisan>>>
    fun getArtisanById(artisanId : String) : Flow<Resource<Artisan>>
}