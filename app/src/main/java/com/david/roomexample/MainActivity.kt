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



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Thread {
            var db = Room.databaseBuilder(applicationContext,MovieDatabase::class.java,"MovieDb")
                .fallbackToDestructiveMigration()
                .build()
        /*
//            var mv = MovieEntity()
//            mv.id = 1
//            mv.name = "una_pelicula_cualquiera"
//            db.movieDAO().saveMovie(mv)

         */
        //}.start()

        //id dataTextView
    }
}
