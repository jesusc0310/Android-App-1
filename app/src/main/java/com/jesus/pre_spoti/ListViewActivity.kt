package com.jesus.pre_spoti

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.PowerManager
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.jesus.pre_spoti.constants.songs
import com.jesus.syisusfy.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        ListView.adapter = ListAdapter(this, songs)

        mediaPlayer = MediaPlayer()
        mediaPlayer.setWakeMode(this, PowerManager.PARTIAL_WAKE_LOCK)


        ListView.setOnItemClickListener { _, _, position, _ ->

            initialiseSeekBar()
            var pos = position

            if (mediaPlayer.isPlaying) {
                mediaPlayer.release()
            }

            mediaPlayer = MediaPlayer.create(this, songs[position].src)
            mediaPlayer.setVolume(1.0f, 1.0f)
            mediaPlayer.start()


            PlayButton.setOnClickListener {
                if (!mediaPlayer.isPlaying) mediaPlayer.start()
            }

            PauseButton.setOnClickListener {
                if (mediaPlayer.isPlaying) mediaPlayer.pause()
            }

            NextButton.setOnClickListener {
                if (pos < songs.size) pos++ else pos = 0
                mediaPlayer.stop()
                mediaPlayer = MediaPlayer.create(this, songs[pos].src)
                mediaPlayer.start()
            }

            PrevButton.setOnClickListener {
                if (position > 0) pos-- else pos = songs.size
                mediaPlayer.stop()
                mediaPlayer = MediaPlayer.create(this, songs[pos].src)
                mediaPlayer.start()
            }
        }
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        if (fromUser)  {
            mediaPlayer.seekTo(progress)
            seekBar?.progress = progress
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }

    private fun initialiseSeekBar() {
        SeekBar.max = mediaPlayer.duration
        val handler = Handler()

        handler.postDelayed(object : Runnable {
            override fun run() {
                try {
                    SeekBar.progress = mediaPlayer.currentPosition
                    handler.postDelayed(this, 1000)
                } catch (e: Exception) {
                    SeekBar.progress = 0
                }
            }
        }, 0)
    }
}