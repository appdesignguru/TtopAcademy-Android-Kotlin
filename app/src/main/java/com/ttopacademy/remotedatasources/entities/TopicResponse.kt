package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey

/** TopicResponse entity class. */
data class TopicResponse(
    @PrimaryKey val topicID: Int,
    val number: Int,
    val name: String
)
