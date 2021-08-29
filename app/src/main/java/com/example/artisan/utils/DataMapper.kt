package com.example.artisan.utils

import com.example.artisan.data.source.remote.ArtisanResponse
import com.example.artisan.domain.model.Artisan
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object DataMapper {

    fun toArtisan(input: List<ArtisanResponse>): Flow<List<Artisan>> {

        val artisanList = ArrayList<Artisan>()
        input.map {
            val artisan = Artisan(
                it.id,
                it.name,
                it.avatar,
                it.image,
                it.userImage,
                it.rating,
                it.description,
                it.services.map{ a ->
                    a.name
                    a.price
                    a.caption
                }
            )

            artisanList.add(artisan)
        }

        return flowOf(artisanList)
    }

    fun toArtisanId(input: ArtisanResponse): Flow<Artisan> =
         flowOf(
             Artisan(
             id = input.id,
             name = input.name,
             avatar = input.avatar,
             image = input.image,
             userImage = input.userImage,
             rating = input.rating,
             description = input.description,
                 services = input.services.map{ a ->
                     a.name
                     a.price
                     a.caption
                 }
             )
         )
}
