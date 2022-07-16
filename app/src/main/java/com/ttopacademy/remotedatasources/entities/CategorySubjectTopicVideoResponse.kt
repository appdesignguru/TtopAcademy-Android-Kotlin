package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey

/** CategorySubjectTopicVideoResponse entity class. */
data class CategorySubjectTopicVideoResponse(
    @PrimaryKey val categorySubjectTopicVideoID: Int,
    val categorySubjectTopiID: Int,
    val videoID: Int
)
