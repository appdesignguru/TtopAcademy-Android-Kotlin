package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey

/** TopicResponse entity class. */
data class TopicResponse(

    /** Returns topicID. */
    @PrimaryKey val topicID: Int,

    /** Returns topic number. */
    val number: Int,

    /** Returns topic name. */
    val name: String
)
