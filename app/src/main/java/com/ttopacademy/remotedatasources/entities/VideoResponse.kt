package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey

/** VideoResponse entity class. */
data class VideoResponse(

    /** Returns videoID. */
    @PrimaryKey val videoID: Int,

    /** Returns video number. */
    val number: Int,

    /** Returns video title. */
    val title: String,

    /** Returns video youtubeID. */
    val youtubeID: String,

    /** Returns video size in MB. */
    val size: String,

    /** Returns solution video youtubeID. */
    val solutionVideoYoutubeID: String,

    /** Returns solution video size in MB. */
    val solutionVideoSize: String
)
