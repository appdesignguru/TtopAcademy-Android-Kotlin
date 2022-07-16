package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey

/** CategorySubjectReponse entity. */
data class CategorySubjectResponse(
    @PrimaryKey val categorySubjectID: Int,
    val categoryID: Int,
    val subjectID: Int
)
