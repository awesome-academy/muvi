package com.example.muvi.data.model

import com.google.gson.annotations.SerializedName

data class DetailMovie(
    val movie: Movie,
    val video: List<Video>,
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("cast")
    val cast: List<Actor>
)
