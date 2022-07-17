package com.ttopacademy.localdatasources.entities

import androidx.room.PrimaryKey
import java.util.*

data class CategorySubjectTopic(

    /** Returns categorySubjectTopicID. */
    @PrimaryKey val categorySubjectTopicID: Int,

    /** Returns categorySubjectID. */
    val categorySubjectID: Int,

    /** Returns topicID. */
    val topicID: Int,

    /** Returns dateSavedToLocalDatabase. */
    val dateSavedToLocalDatabase: Date
)
