package com.david.roomexample.model

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor




/**
 * DataService provides all data related to items
 *
 * @author david.mazo
 */

class DataSource(private val listeningActivity: ResponseInterface?) {

    interface ResponseInterface {
        fun sendResponse(response: ArrayList<ApiMovie>?)
    }

    var isLoadingData: Boolean = false
    private val retrofit: Retrofit
    private val service: ApiService

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        retrofit = Retrofit.Builder()
                .baseUrl(BaseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(ApiService::class.java)
    }

    fun getData() {
        val call = service.getCurrentData(AppId)
        isLoadingData = true

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {


                Log.e("#009","respuesta"+response.code().toString())
                if (response.code() == 200) {
                    itemResponse(response)
                } else {
                    itemResponse(null)
                }
                isLoadingData = false
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                t.printStackTrace()
                itemResponse(null)
                isLoadingData = false
            }
        })
    }

    private fun itemResponse(apiResponse: Response<ApiResponse>?) {

        apiResponse?.body()?.let { response ->
            listeningActivity?.sendResponse(response.results)
        }
    }

    fun getDataDetail() {
        val call = service.getCurrentData(AppId)
        isLoadingData = true
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.code() == 200) {
                    itemResponse(response)
                } else {
                    itemResponse(null)
                }
                isLoadingData = false
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                t.printStackTrace()
                itemResponse(null)
                isLoadingData = false
            }
        })

    }


    companion object {
        var BaseUrl = "https://api.themoviedb.org/3/"
        var AppId = "63ed8a8536056a6fb3852790679147a3"
    }
}
