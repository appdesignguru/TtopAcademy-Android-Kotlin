package com.ttopacademy.localdatasources.entities

import androidx.room.PrimaryKey
import java.util.*

/** CategorySubjectTopicVideo entity class. */
data class CategorySubjectTopicVideo(

    /** Returns categorySubjectTopicVideoID. */
    @PrimaryKey val categorySubjectTopicVideoID: Int,

    /** Returns categorySubjectTopicID. */
    val categorySubjectTopiID: Int,

    /** Returns videoID. */
    val videoID: Int,

    /** Returns dateSavedToLocalDatabase. */
    var dateSavedToLocalDatabase: Date
)
