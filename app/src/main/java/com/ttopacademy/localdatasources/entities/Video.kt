package com.ttopacademy.localdatasources.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/** Video entity class. */
@Entity
data class Video(

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
    val solutionVideoSize: String,

    /** Returns dateSavedToLocalDatabase. */
    var dateSavedToLocalDatabase: Date?
)
