package com.ttopacademy.localdatasources.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/** Subject entity class. */
@Entity
data class Subject(

    /** Returns subjectID. */
    @PrimaryKey val subjectID: Int,

    /** Returns subject number. */
    val number: Int,

    /** Returns subject name. */
    val name: String,

    /** Returns dateSavedToLocalDatabase*/
    var dateSavedToLocalDatabase: Date
)
