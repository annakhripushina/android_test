package com.sirius.test_app.ui.dota2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.data.model.ReviewModel
import com.sirius.test_app.databinding.ItemReviewBinding

class ReviewAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var reviews: List<ReviewModel> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ReviewViewHolder -> {
                holder.bind(reviews[position])
            }
        }
    }

    override fun getItemCount(): Int =
        reviews.size

}