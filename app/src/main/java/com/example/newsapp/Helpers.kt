package com.example.newsapp

import android.content.Intent
import com.example.newsapp.data.DataNews
import com.example.newsapp.databinding.NewsHeadlineBinding

fun bindingNewsHeadline(binding: NewsHeadlineBinding, position: Int) {
    binding.apply {
        imgHeadline.setImageResource(DataNews.photoHeadline[position])
        tvTitleHeadline.text = DataNews.titleHeadline[position]
        tvDescHeadline.text = DataNews.contentHeadline[position]
        tvDateHeadline.text = DataNews.dateHeadline[position]
        tvAuthorHeadline.text = DataNews.authorHeadline[position]
    }

    binding.root.setOnClickListener{
        val intentTodetail = Intent(binding.root.context, DetailActivity::class.java)

        intentTodetail.putExtra(DetailActivity.EXTRA_IMG_HEADLINE, DataNews.photoHeadline[position])
        intentTodetail.putExtra(DetailActivity.EXTRA_TITLE_HEADLINE, DataNews.titleHeadline[position])
        intentTodetail.putExtra(DetailActivity.EXTRA_CONTENT_HEADLINE, DataNews.contentHeadline[position])
        intentTodetail.putExtra(DetailActivity.EXTRA_DATE_HEADLINE, DataNews.dateHeadline[position])
        intentTodetail.putExtra(DetailActivity.EXTRA_AUTHOR_HEADLINE, DataNews.authorHeadline[position])

        binding.root.context.startActivity(intentTodetail)
    }

}