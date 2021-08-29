package com.example.artisan.api

import com.example.artisan.data.source.remote.ArtisanResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET("list-artisan")
    suspend fun getAllArtisan() : List<ArtisanResponse>

    @GET("list-artisan/{id}")
    suspend fun getArtisanById(@Path("id") artisanId : String) : ArtisanResponse
}