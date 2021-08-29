package com.example.artisan.domain.repository

import com.example.artisan.domain.model.Artisan
import com.example.artisan.domain.usecase.ArtisanUseCase
import com.example.artisan.utils.Resource
import kotlinx.coroutines.flow.Flow

class ArtisanIterator (private val artisanRepository: IArtisanRepository) : ArtisanUseCase {
    override fun getAllArtisan(): Flow<Resource<List<Artisan>>> {
        return artisanRepository.getAllArtisan()
    }

    override fun getArtisanById(artisanId: String): Flow<Resource<Artisan>> {
        return artisanRepository.getArtisanById(artisanId)
    }


}