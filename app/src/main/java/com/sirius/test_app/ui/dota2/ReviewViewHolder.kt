package com.sirius.test_app.ui.dota2

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sirius.test_app.data.model.ReviewModel
import com.sirius.test_app.databinding.ItemReviewBinding

class ReviewViewHolder(private val binding: ItemReviewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(review: ReviewModel) {
        binding.userName.text = review.userName
        binding.date.text = review.date
        binding.message.text = review.message

        Glide.with(binding.userImage.context)
            .load(review.userImage)
            .centerCrop()
            .into(binding.userImage)
    }
}