package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey

/** SubjectResponse entity class. */
data class SubjectResponse(

    /** Returns subjectID. */
    @PrimaryKey val subjectID: Int,

    /** Returns subject number. */
    val number: Int,

    /** Returns subject name. */
    val name: String
)
