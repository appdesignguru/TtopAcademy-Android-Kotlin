package com.ttopacademy.localdatasources.entities

import androidx.room.PrimaryKey
import java.util.*

data class Subject(
    @PrimaryKey val subjectID: Int,
    val number: Int,
    val name: String,
    val dateSavedToLocalDatabase: Date
)
