package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.data.News
import com.example.newsapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val NEWS_DATA = "com/example/newsapp/data"

        const val EXTRA_IMG_HEADLINE = "image"
        const val EXTRA_TITLE_HEADLINE = "title"
        const val EXTRA_CONTENT_HEADLINE = "content"
        const val EXTRA_DATE_HEADLINE = "date"
        const val EXTRA_AUTHOR_HEADLINE = "author"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "New Detail"
        }

        val news = intent.getParcelableExtra<News>(NEWS_DATA)

        val photoHeadline = intent.getIntExtra(EXTRA_IMG_HEADLINE, 0)
        val titleHeadline = intent.getStringExtra(EXTRA_TITLE_HEADLINE)
        val contentHeadline = intent.getStringExtra(EXTRA_CONTENT_HEADLINE)
        val dateHeadline = intent.getStringExtra(EXTRA_DATE_HEADLINE)
        val authorHeadline = intent.getStringExtra(EXTRA_AUTHOR_HEADLINE)

        binding.imgNewsDetail.setImageResource(photoHeadline)
        binding.tvTitleDetail.text = titleHeadline
        binding.tvDateDetail.text = dateHeadline
        binding.tvAuthorDetail.text = authorHeadline
        binding.tvContentDetail.text = contentHeadline

        if(news != null){
            binding.tvTitleDetail.text = news.title
            binding.tvAuthorDetail.text = news.author
            binding.tvDateDetail.text = news.date
            binding.tvContentDetail.text = news.content
            binding.imgNewsDetail.setImageResource(news.photo)
        } else {
            binding.imgNewsDetail.setImageResource(photoHeadline)
            binding.tvTitleDetail.text = titleHeadline
            binding.tvDateDetail.text = dateHeadline
            binding.tvAuthorDetail.text = authorHeadline
            binding.tvContentDetail.text = contentHeadline
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}

