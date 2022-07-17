package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey

/** CategorySubjectReponse entity. */
data class CategorySubjectResponse(

    /** Returns categorySubjectID. */
    @PrimaryKey val categorySubjectID: Int,

    /** Returns categoryID. */
    val categoryID: Int,

    /** Returns subjectID. */
    val subjectID: Int
)
