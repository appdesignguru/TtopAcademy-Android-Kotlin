package com.ttopacademy.localdatasources.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/** CategorySubject entity class. */
@Entity
data class CategorySubject(

    /** Returns categorySubjectID. */
    @PrimaryKey val categorySubjectID: Int,

    /** Returns categoryID. */
    val categoryID: Int,

    /** Returns subjectID. */
    val subjectID: Int,

    /** Returns subjectID. */
    var dateSavedToLocalDatabase: Date?
)
