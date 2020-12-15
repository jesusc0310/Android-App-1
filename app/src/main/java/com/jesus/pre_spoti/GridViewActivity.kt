package com.jesus.pre_spoti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jesus.pre_spoti.adapters.GridAdapter
import kotlinx.android.synthetic.main.activity_grid_view.*

class GridViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        GridView.adapter = GridAdapter(applicationContext)
    }
}