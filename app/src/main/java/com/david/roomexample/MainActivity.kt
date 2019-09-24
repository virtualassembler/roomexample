package com.david.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.david.roomexample.model.MovieDao
import com.david.roomexample.model.MovieDatabase
import com.david.roomexample.model.MovieEntity
import android.os.AsyncTask
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db = Room.databaseBuilder(applicationContext,MovieDatabase::class.java,"MovieDb")
            .fallbackToDestructiveMigration()
            .build()

        Thread {
            var mv = MovieEntity()
            mv.name = "UNA_PELICULA_CUALQUIERA"
            db.movieDAO().saveMovie(mv)
            val moviesFromDb = db.movieDAO().getMovies()

            moviesFromDb.forEachIndexed { index, element ->
                Log.d("#001","query: "+index.toString()+element.toString())
            }

            for(movie in moviesFromDb){
                Log.d("#002","query: "+movie.toString())
            }

            db.close()
        }.start()

        //id dataTextView
    }
}
