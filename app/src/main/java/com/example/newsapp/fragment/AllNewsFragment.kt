package com.example.newsapp.fragment

import com.example.newsapp.adapter.NewsAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.bindingNewsHeadline
import com.example.newsapp.data.DataNews
import com.example.newsapp.databinding.FragmentAllNewsBinding

class AllNewsFragment : Fragment() {

    lateinit var binding: FragmentAllNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this com.example.newsapp.fragment
        binding = FragmentAllNewsBinding.inflate(inflater, container, false)

        binding.rvAllNews.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = NewsAdapter(DataNews.dataAllNews)

        }
        binding.newsHeadline.apply {
            imgHeadline.setImageResource(DataNews.photoHeadline[0])
            tvTitleHeadline.text = (DataNews.titleHeadline[0])
            tvDescHeadline.text = (DataNews.contentHeadline[0])
            tvDateHeadline.text = (DataNews.dateHeadline[0])
            tvAuthorHeadline.text = (DataNews.authorHeadline[0])
        }
//        TODO Hiii
        bindingNewsHeadline(binding.newsHeadline, 0)

        return binding.root

    }

}

