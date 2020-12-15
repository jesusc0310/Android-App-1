package com.jesus.pre_spoti

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.SeekBar
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoViewActivity : AppCompatActivity() {

    var simpleVideoView: VideoView? = null

    var mediaController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

        simpleVideoView = findViewById(R.id.VideoView)

        if (mediaController == null) {
            mediaController = MediaController(this)
            mediaController!!.setAnchorView(this.simpleVideoView)
        }

        simpleVideoView!!.setMediaController(mediaController)

        simpleVideoView!!.setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.video}"))

        simpleVideoView!!.requestFocus()

        simpleVideoView!!.start()
    }
}