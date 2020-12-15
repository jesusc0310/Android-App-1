package com.jesus.syisusfy.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.jesus.pre_spoti.R
import com.jesus.pre_spoti.model.Song

class ListAdapter(private val context: Activity, private val songs: Array<Song>) :
    ArrayAdapter<Song>(context, R.layout.song_list, songs) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.song_list, null, true)

        val title = rowView.findViewById<TextView>(R.id.songTitle)
        val image = rowView.findViewById<ImageView>(R.id.songImage)
        val author = rowView.findViewById<TextView>(R.id.songAuthor)

        title.text = songs[position].title
        image.setImageResource(songs[position].image)
        author.text = songs[position].author

        return rowView
    }
}