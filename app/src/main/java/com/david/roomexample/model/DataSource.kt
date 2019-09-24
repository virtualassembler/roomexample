package com.globant.training.ammolite.model

import android.content.Context
import com.david.roomexample.model.MovieEntity

/**
 * DataSource provides all data related to movies
 *
 * @author david.mazo
 */

class DataSource {

    fun getMoviesList(context: Context): ArrayList<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(MovieEntity(1, "MovieEntity 1"))
        movies.add(MovieEntity(2, "MovieEntity 2"))
        movies.add(MovieEntity(3, "MovieEntity 3"))
        movies.add(MovieEntity(4, "MovieEntity 4"))
        return movies
    }
}
