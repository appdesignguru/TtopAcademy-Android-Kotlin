package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey

/** SubjectResponse entity class. */
data class SubjectResponse(
    @PrimaryKey val subjectID: Int,
    val number: Int,
    val name: String
)
