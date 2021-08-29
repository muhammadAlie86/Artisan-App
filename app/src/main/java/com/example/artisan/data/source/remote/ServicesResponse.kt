package com.example.artisan.data.source.remote

import com.google.gson.annotations.SerializedName

data class ServicesResponse(

    @SerializedName("name")
    val name : String,

    @SerializedName("price")
    val price : String,

    @SerializedName("caption")
    val caption : String
)