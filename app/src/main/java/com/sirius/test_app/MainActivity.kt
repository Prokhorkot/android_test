package com.sirius.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private val tagsAdapter = CategoryAdapter()
    private val reviewAdapter = ReviewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide();
        setContentView(R.layout.activity_main)
        loadComponents()
    }

    fun loadComponents(){
        val imageView16 = findViewById<ImageView>(R.id.image_16)
        val imageView17 = findViewById<ImageView>(R.id.image_17)
        val appName = findViewById<TextView>(R.id.appName)
        val downloadsCount = findViewById<TextView>(R.id.downloadsCount)
        val tagsRv = findViewById<RecyclerView>(R.id.tagsRv)
        val description = findViewById<TextView>(R.id.description)
        val downloadsCount_2 = findViewById<TextView>(R.id.downloadsCount_2)
        val reviewsRv = findViewById<RecyclerView>(R.id.reviewsRv)

        val dataModel = DataModel()
        Picasso.get().load(dataModel.image).into(imageView16)
        Picasso.get().load(dataModel.logo).into(imageView17)

        appName.text = dataModel.name
        downloadsCount.text = dataModel.gradeCnt

        tagsRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        tagsRv.adapter = tagsAdapter
        tagsAdapter.initializeList(dataModel.tags)

        description.text = dataModel.description

        downloadsCount_2.text = dataModel.gradeCnt + " Reviews"

        reviewsRv.layoutManager = LinearLayoutManager(this)
        reviewsRv.adapter = reviewAdapter
        reviewAdapter.initializeReviews(dataModel.reviews)
    }
}