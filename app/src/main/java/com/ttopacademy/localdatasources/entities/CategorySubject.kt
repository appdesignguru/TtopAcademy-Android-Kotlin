package com.ttopacademy.localdatasources.entities

import androidx.room.PrimaryKey

data class CategorySubject(
    @PrimaryKey val categorySubjectID: Int,
    val categoryID: Int,
    val subjectID: Int,
    val dateSavedToLocalDatabase: Int
)
