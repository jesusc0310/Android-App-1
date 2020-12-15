package com.jesus.pre_spoti.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.jesus.pre_spoti.R
import com.jesus.pre_spoti.constants.albums

class GridAdapter(var context: Context) : BaseAdapter() {
    override fun getCount(): Int {
        return albums.size
    }

    override fun getItem(position: Int): Any {
        return albums[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = View.inflate(context, R.layout.album_list, null)

        var image = view.findViewById<ImageView>(R.id.AlbumImage)
        var name = view.findViewById<TextView>(R.id.AlbumName)

        image.setImageResource(albums[position].photo)
        name.text = albums[position].title

        return view
    }
}