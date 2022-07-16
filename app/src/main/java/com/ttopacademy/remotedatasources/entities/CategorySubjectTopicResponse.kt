package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey

/** CategorySubjectTopicResponse entity. */
data class CategorySubjectTopicResponse(
    @PrimaryKey val categorySubjectTopicID: Int,
    val categorySubjectID: Int,
    val topicID: Int
)
