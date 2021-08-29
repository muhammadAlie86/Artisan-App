package com.example.artisan.data.source

import android.util.Log
import com.example.artisan.api.ApiServices
import com.example.artisan.data.source.remote.ArtisanResponse
import com.example.artisan.utils.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class RemoteDataSource(private val apiServices : ApiServices) {

    fun getAllArtisan(): Flow<ApiResponse<List<ArtisanResponse>>> {

        return flow {
            try {
                val response = apiServices.getAllArtisan()
                if (response.isNotEmpty() ) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getArtisanById(artisanId: String): Flow<ApiResponse<ArtisanResponse>> {

        return flow {
            try {
                val response = apiServices.getArtisanById(artisanId)
                if (response.id.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}