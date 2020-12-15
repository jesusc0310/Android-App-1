package com.jesus.pre_spoti.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jesus.pre_spoti.R
import com.jesus.pre_spoti.constants.songs
import com.jesus.pre_spoti.model.Song


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(songs[position])
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.song_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.songTitle)
        val author = view.findViewById<TextView>(R.id.songAuthor)
        val image = view.findViewById<ImageView>(R.id.songImage)

        fun bind(song: Song) {
            title.text = song.title
            author.text = song.author
            image.setImageResource(song.image)
        }
    }
}