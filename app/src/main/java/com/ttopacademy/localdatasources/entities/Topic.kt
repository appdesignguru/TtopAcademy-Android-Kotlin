package com.ttopacademy.localdatasources.entities

import androidx.room.PrimaryKey
import java.util.*

data class Topic(
    @PrimaryKey val topicID: Int,
    val number: Int,
    val name: String,
    val dateSavedToLocalDatabase: Date
)
