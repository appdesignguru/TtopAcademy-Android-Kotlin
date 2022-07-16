package com.ttopacademy.localdatasources.entities

import androidx.room.PrimaryKey
import java.util.*

data class Video(
    @PrimaryKey val videoID: Int,
    val number: Int,
    val title: String,
    val youtubeID: String,
    val size: String,
    val solutionVideoYoutubeID: String,
    val solutionVideoSize: String,
    val dateSavedToLocalDatabase: Date
)
