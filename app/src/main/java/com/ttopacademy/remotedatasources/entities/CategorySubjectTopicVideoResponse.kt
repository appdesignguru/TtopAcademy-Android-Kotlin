package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey

/** CategorySubjectTopicVideoResponse entity class. */
data class CategorySubjectTopicVideoResponse(

    /** Returns categorySubjectTopicVideoID. */
    @PrimaryKey val categorySubjectTopicVideoID: Int,

    /** Returns categorySubjectTopicID. */
    val categorySubjectTopiID: Int,

    /** Returns videoID. */
    val videoID: Int
)
