package com.example.interview.tools.db.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.interview.model.MovieResultItemModel

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMoviesList(moviesList: List<MovieResultItemModel>)

    @Query("SELECT * FROM movie")
    suspend fun getAllMovies(): List<MovieResultItemModel>
}