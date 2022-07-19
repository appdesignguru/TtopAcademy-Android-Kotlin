package com.ttopacademy.localdatasources.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/** CategorySubjectTopicVideo entity class. */
@Entity
data class CategorySubjectTopicVideo(

    /** Returns categorySubjectTopicVideoID. */
    @PrimaryKey val categorySubjectTopicVideoID: Int,

    /** Returns categorySubjectTopicID. */
    val categorySubjectTopicID: Int,

    /** Returns videoID. */
    val videoID: Int,

    /** Returns dateSavedToLocalDatabase. */
    var dateSavedToLocalDatabase: Date
)
