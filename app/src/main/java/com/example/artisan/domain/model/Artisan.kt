package com.example.artisan.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Artisan(
    val id: String,
    val name: String,
    val avatar: String,
    val image: String,
    val userImage: String,
    val rating: String,
    val description: String,
    val services: List<String>

) :  Parcelable