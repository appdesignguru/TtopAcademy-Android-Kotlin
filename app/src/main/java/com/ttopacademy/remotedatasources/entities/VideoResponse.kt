package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey

/** VideoResponse entity class. */
data class VideoResponse(
    @PrimaryKey val videoID: Int,
    val number: Int,
    val title: String,
    val youtubeID: String,
    val size: String,
    val solutionVideoYoutubeID: String,
    val solutionVideoSize: String
)
