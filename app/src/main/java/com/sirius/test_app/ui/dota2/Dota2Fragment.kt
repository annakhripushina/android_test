package com.sirius.test_app.ui.dota2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.sirius.test_app.App
import com.sirius.test_app.R
import com.sirius.test_app.data.model.DataModel
import com.sirius.test_app.databinding.FragmentDota2Binding
import com.sirius.test_app.presentation.Dota2ViewModel
import javax.inject.Inject

class Dota2Fragment : Fragment() {
    @Inject
    lateinit var viewModel: Dota2ViewModel

    private lateinit var binding: FragmentDota2Binding

    private val reviewAdapter = ReviewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity().applicationContext as App).appComponent.inject(this)
        binding = FragmentDota2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        viewModel.getDataDota2()

        viewModel.data.observe(viewLifecycleOwner, Observer {
            setDataView(it)
        })
    }

    private fun initRecycler() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.reviews.apply {
            adapter = reviewAdapter
            layoutManager = linearLayoutManager
        }
    }

    private fun setDataView(data: DataModel) {
        Glide.with(binding.image.context)
            .load(data.image)
            .centerCrop()
            .into(binding.image)

        Glide.with(binding.logo.context)
            .load(data.logo)
            .centerCrop()
            .into(binding.logo)

        binding.name.text = data.name

        binding.ratingBar.rating = data.rating

        binding.gradeCnt.text = data.gradeCnt

        binding.description.text = data.description

        data.tags.forEach {
            val tagView = layoutInflater.inflate(R.layout.tag_textview, null)
            tagView.findViewById<TextView>(R.id.tag).text = it
            binding.tags.addView(tagView)
        }

        binding.rating.text = data.rating.toString()

        binding.reviewRatingBar.rating = data.rating

        binding.reviewsCnt.text = context?.getString(R.string.reviewsCnt, data.gradeCnt)

        reviewAdapter.reviews = data.reviews

        binding.install.text = data.action.name
    }
}