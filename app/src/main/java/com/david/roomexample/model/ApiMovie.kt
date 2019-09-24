package com.david.roomexample.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movie")
data class ApiMovie(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @SerializedName("identification")
    val identification: String? = null,
    @SerializedName("popularity")
    val popularity: String? = null,
    @SerializedName("vote_count")
    val vote_count: String? = null,
    @SerializedName("video")
    val video: String? = null,
    @SerializedName("poster_path")
    val poster_path: String? = null,
    @SerializedName("adult")
    val adult: String? = null,
    @SerializedName("backdrop_path")
    val backdrop_path: String? = null,
    @SerializedName("original_language")
    val original_language: String? = null,
    @SerializedName("original_title")
    val original_title: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("vote_average")
    val vote_average: String? = null,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("release_date")
    val release_date: String? = null
) : Parcelable
