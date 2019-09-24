package com.david.roomexample

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.david.roomexample.model.ApiMovie
import kotlinx.android.synthetic.main.detail_item.imageView_movie_picture
import kotlinx.android.synthetic.main.detail_item.image_view_ic_star
import kotlinx.android.synthetic.main.detail_item.ratingBar_average
import kotlinx.android.synthetic.main.detail_item.textView_average
import kotlinx.android.synthetic.main.detail_item.textView_movie_title
import kotlinx.android.synthetic.main.detail_item.textView_overview
import kotlinx.android.synthetic.main.detail_item.textView_title_original
import kotlinx.android.synthetic.main.detail_item.textView_title_release_date

class DetailItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_item)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val item: ApiMovie = intent.getParcelableExtra<ApiMovie>("object_recycler_view")
        textView_movie_title.text = item.title
        textView_title_original.text = item.original_title
        ratingBar_average.rating = (item.vote_average?.toFloat() ?: 0f) / 2
        textView_average.text = ((item.vote_average?.toFloat() ?: 0f) / 2).toString()
        textView_title_release_date.text = item.release_date
        textView_overview.text = item.overview
        Glide.with(imageView_movie_picture)
            .load("http://image.tmdb.org/t/p/w500" + item.poster_path)
            .centerCrop()
            .override(1000, 1000)
            .into(imageView_movie_picture)
        Glide.with(image_view_ic_star)
            .load("http://image.tmdb.org/t/p/w500" + item.backdrop_path)
            .centerCrop()
            .override(1000, 1000)
            .into(image_view_ic_star)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }
}
