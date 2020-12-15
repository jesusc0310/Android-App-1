package com.jesus.pre_spoti

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ListViewButton.setOnClickListener {
            startActivity(Intent(this, ListViewActivity::class.java))
        }

        GridViewButton.setOnClickListener {
            startActivity(Intent(this, GridViewActivity::class.java))
        }

        RecyclerViewButton.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }

        VideoViewButton.setOnClickListener {
            startActivity(Intent(this, VideoViewActivity::class.java))
        }

        WebViewButton.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }
    }
}