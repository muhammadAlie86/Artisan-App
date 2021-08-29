package com.example.artisan.data.repository

import com.example.artisan.data.source.NetworkResource
import com.example.artisan.data.source.RemoteDataSource
import com.example.artisan.data.source.remote.ArtisanResponse
import com.example.artisan.domain.model.Artisan
import com.example.artisan.domain.repository.IArtisanRepository
import com.example.artisan.utils.ApiResponse
import com.example.artisan.utils.DataMapper
import com.example.artisan.utils.Resource
import kotlinx.coroutines.flow.Flow

class ArtisanRepository(
    private val remoteDataSource: RemoteDataSource
) : IArtisanRepository{

    override fun getAllArtisan(): Flow<Resource<List<Artisan>>> {
        return object : NetworkResource<List<Artisan>,List<ArtisanResponse>>() {
            override fun loadFromNetwork(data: List<ArtisanResponse>): Flow<List<Artisan>> {
                return DataMapper.toArtisan(data)
            }

            override fun createCall(): Flow<ApiResponse<List<ArtisanResponse>>> {
                return remoteDataSource.getAllArtisan()
            }

        }.asFlow()
    }

    override fun getArtisanById(artisanId: String): Flow<Resource<Artisan>> {
        return object : NetworkResource<Artisan, ArtisanResponse>() {
            override fun loadFromNetwork(data: ArtisanResponse): Flow<Artisan> {
                return DataMapper.toArtisanId(data)
            }

            override fun createCall(): Flow<ApiResponse<ArtisanResponse>> {
                return remoteDataSource.getArtisanById(artisanId)
            }

        }.asFlow()

    }
}