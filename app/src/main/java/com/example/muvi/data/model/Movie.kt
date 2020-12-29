package com.example.muvi.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("vote_average")
    var rate: Float,
    @SerializedName("overview")
    var description: String,
    @SerializedName("poster_path")
    var poster: String?,
    @SerializedName("backdrop_path")
    var background: String?,
    @SerializedName("release_date")
    var releaseDate: String,
    @SerializedName("runtime")
    var runtime: Int,
    @Ignore
    @SerializedName("genre_ids")
    var genreIds: List<Int>,
    @Ignore
    @SerializedName("genres")
    var genres: List<Genre>,
    @Ignore
    @SerializedName("production_companies")
    var productionCompanies: List<Company>
) : GeneralEntity {

    constructor(
        id: Int,
        title: String,
        rate: Float,
        description: String,
        poster: String?,
        background: String?,
        releaseDate: String,
        runtime: Int
    ) : this(
        id,
        title,
        rate,
        description,
        poster,
        background,
        releaseDate,
        runtime,
        listOf(),
        listOf(),
        listOf()
    )

    override fun areItemsTheSame(newItem: GeneralEntity): Boolean =
        newItem is Movie && this.id == newItem.id

    override fun areContentsTheSame(newItem: GeneralEntity): Boolean =
        newItem is Movie && this == newItem
}
