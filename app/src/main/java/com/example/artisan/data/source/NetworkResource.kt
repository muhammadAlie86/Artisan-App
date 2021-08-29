package com.example.artisan.data.source

import com.example.artisan.utils.ApiResponse
import com.example.artisan.utils.Resource
import kotlinx.coroutines.flow.*

abstract class NetworkResource <ResultType,RequestType>{

    private val result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = createCall().first()) {
            is ApiResponse.Success -> {
                emitAll(loadFromNetwork(apiResponse.data).map {
                    Resource.Success(it)
                })
            }

            is ApiResponse.Error -> {
                emit(Resource.Error<ResultType>(apiResponse.errorMessage))
            }
        }
    }


    protected abstract fun loadFromNetwork(data: RequestType): Flow<ResultType>

    protected abstract fun createCall(): Flow<ApiResponse<RequestType>>

    fun asFlow(): Flow<Resource<ResultType>> = result
}