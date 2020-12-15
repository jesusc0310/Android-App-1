package com.jesus.pre_spoti

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jesus.pre_spoti.adapters.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        RecyclerView.apply {
            setHasFixedSize(true)
            adapter = RecyclerAdapter()
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }
}