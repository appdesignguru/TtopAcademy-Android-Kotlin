package com.ttopacademy.localdatasources.entities

import androidx.room.PrimaryKey
import java.util.*

data class CategorySubjectTopicVideo(
    @PrimaryKey val categorySubjectTopicVideoID: Int,
    val categorySubjectTopiID: Int,
    val videoID: Int,
    val dateSavedToLocalDatabase: Date
)
