package com.ttopacademy.localdatasources.entities

import androidx.room.PrimaryKey
import java.util.*

data class CategorySubjectTopic(
    @PrimaryKey val categorySubjectTopicID: Int,
    val categorySubjectID: Int,
    val topicID: Int,
    val dateSavedToLocalDatabase: Date
)
