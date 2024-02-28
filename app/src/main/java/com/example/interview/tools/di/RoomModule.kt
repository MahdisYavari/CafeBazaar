package com.example.interview.tools.di

import android.content.Context
import androidx.room.Room
import com.example.interview.tools.db.room.MovieDao
import com.example.interview.tools.db.room.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): MovieDatabase {
        return Room
            .databaseBuilder(
                context,
                MovieDatabase::class.java,
                "movie_database"
            )
            .fallbackToDestructiveMigration()
            .build()
    }
    @Singleton
    @Provides
    fun provideMovieDAO(movieDataBase: MovieDatabase): MovieDao {
        return movieDataBase.getMovieDao()
    }

}