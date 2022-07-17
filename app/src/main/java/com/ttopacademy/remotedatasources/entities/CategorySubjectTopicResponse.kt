package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey

/** CategorySubjectTopicResponse entity. */
data class CategorySubjectTopicResponse(

    /** Returns categorySubjectTopicID. */
    @PrimaryKey val categorySubjectTopicID: Int,

    /** Returns categorySubjectID. */
    val categorySubjectID: Int,

    /** Returns topicID. */
    val topicID: Int
)
