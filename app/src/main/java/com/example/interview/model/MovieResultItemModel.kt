package com.example.interview.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "movie"
)
class MovieResultItemModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val overview: String? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val video: Boolean? = null,
    val title: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val releaseDate: String? = null,
    val adult: Boolean? = null,
    val voteCount: Int? = null
)