package com.david.roomexample.model

import com.google.gson.annotations.SerializedName

class ApiResponse {
    @SerializedName("page")
    val page: Int = 0
    @SerializedName("total_results")
    val total_results: Double = 0.0
    @SerializedName("total_pages")
    val total_pages: Double = 0.0
    @SerializedName("results")
    val results: ArrayList<ApiMovie>? = null
}