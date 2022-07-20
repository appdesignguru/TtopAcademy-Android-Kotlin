package com.ttopacademy.localdatasources.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/** CategorySubjectTopic entity class. */
@Entity
data class CategorySubjectTopic(

    /** Returns categorySubjectTopicID. */
    @PrimaryKey val categorySubjectTopicID: Int,

    /** Returns categorySubjectID. */
    val categorySubjectID: Int,

    /** Returns topicID. */
    val topicID: Int,

    /** Returns dateSavedToLocalDatabase. */
    var dateSavedToLocalDatabase: Date?
)
