package com.david.roomexample.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveMovie(movie: MovieEntity)

    @Query("SELECT * from movies")
    fun getMovies(): List<MovieEntity>

    /*
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movieEntity: MovieEntity)
    @Query("SELECT * FROM movies LIMIT 1")
    suspend fun getAppMovie(): MovieEntity?
    @Update
    suspend fun update(movieEntity: MovieEntity)
    @Delete
    suspend fun deleteMovie(movieEntity: MovieEntity)
    @Transaction
    suspend fun setMovie(movieEntity: MovieEntity) {
        deleteMovie(movieEntity)
        insertMovie(movieEntity)
    }
    */
}
