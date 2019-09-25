package com.david.roomexample

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.david.roomexample.adapters.CustomAdapter
import com.david.roomexample.interfaces.AdapterEvents
import com.david.roomexample.model.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepository(applicationContext: Context) {


    private val retrofit: Retrofit
    private val service: ApiService

    private var movieDatabase: MovieDatabase

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        retrofit = Retrofit.Builder()
            .baseUrl(DataSource.BaseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ApiService::class.java)

        movieDatabase = Room.databaseBuilder(applicationContext, MovieDatabase::class.java,"MovieDb")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun syncData() {
        service.getCurrentData(DataSource.AppId)
            .enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    Log.e("#009", "respuesta" + response.code().toString())
                    if (response.code() == 200) {
                        response.body()?.let { response ->
                            for (item: ApiMovie in response.results as List<ApiMovie>) {
                                saveMovieIntoDB(item)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }

    fun saveMovieIntoDB(movie: ApiMovie) {
        Thread {
            if (movieDatabase.isOpen) {
                    movieDatabase.runInTransaction {
                    movieDatabase.movieDAO().saveMovie(movie)
                }
                movieDatabase.close()
            }
        }.start()
    }







   fun getMoviesFromLocalDB(listener: AdapterEvents, context: Context) {
       Thread {
           var arrayListItems:ArrayList<ApiMovie>
           var listItems:List<ApiMovie>
            if (movieDatabase.isOpen) {
                movieDatabase.runInTransaction {
                    listItems = movieDatabase.movieDAO().getMovies()

                    val array = arrayListOf<ApiMovie>()
                    array.addAll(listItems)
                    arrayListItems=ArrayList(listItems)


                    CustomAdapter(listener,context).showAll(arrayListItems)
                    movieDatabase.close()
                }
            }else{
                Log.e("#010","error #010")
            }
       }.start()
    }


    fun aa() {
        Log.e("asa","sadf")
    }


}