package com.ttopacademy.localdatasources.entities

import androidx.room.PrimaryKey

data class CategorySubject(

    /** Returns categorySubjectID. */
    @PrimaryKey val categorySubjectID: Int,

    /** Returns categoryID. */
    val categoryID: Int,

    /** Returns subjectID. */
    val subjectID: Int,

    /** Returns subjectID. */
    val dateSavedToLocalDatabase: Int
)
