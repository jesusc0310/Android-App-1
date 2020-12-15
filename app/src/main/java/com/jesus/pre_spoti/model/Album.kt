package com.jesus.pre_spoti.model

data class Album(
    val photo: Int,
    val title: String,
    val songs: Array<Song>,
)