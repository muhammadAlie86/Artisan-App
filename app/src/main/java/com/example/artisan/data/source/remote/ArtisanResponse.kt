package com.example.artisan.data.source.remote

import com.google.gson.annotations.SerializedName

data class ArtisanResponse (
    @SerializedName("id")
    val id : String,

    @SerializedName("name")
    val name : String,

    @SerializedName("avatar")
    val avatar : String,

    @SerializedName("image")
    val image : String,

    @SerializedName("user_image")
    val userImage : String,

    @SerializedName("rating")
    val rating : String,

    @SerializedName("description")
    val description : String,

    @SerializedName("services")
    val services : List<ServicesResponse>

)