package com.ttopacademy.localdatasources.entities

import androidx.room.PrimaryKey
import java.util.*

data class Topic(

    /** Returns topicID. */
    @PrimaryKey val topicID: Int,

    /** Returns topic number. */
    val number: Int,

    /** Returns topic name. */
    val name: String,

    /** Returns dateSavedToLocalDatabase*/
    var dateSavedToLocalDatabase: Date
)
