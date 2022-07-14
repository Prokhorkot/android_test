package com.sirius.test_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.databinding.ReviewItemBinding
import com.squareup.picasso.Picasso

class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.ReviewHolder>() {

    val reviewList = ArrayList<ReviewModel>()

    class ReviewHolder(item: View) : RecyclerView.ViewHolder(item){
        private val binding = ReviewItemBinding.bind(item)

        fun bind(review: ReviewModel) = with(binding){
            Picasso.get().load(review.userImage).into(userPhoto)
            userName.text = review.userName
            reviewDate.text = review.date
            reviewContent.text = review.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.review_item, parent, false)
        return ReviewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewHolder, position: Int) {
        holder.bind(reviewList[position])
    }
    override fun getItemCount(): Int {
        return reviewList.size
    }

    fun initializeReviews(reviews: List<ReviewModel>){
        for (review in reviews){
            reviewList.add(review)
        }
        notifyDataSetChanged()
    }

}