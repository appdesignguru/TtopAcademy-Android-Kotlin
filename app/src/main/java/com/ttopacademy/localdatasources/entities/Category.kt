package com.ttopacademy.localdatasources.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/** Category entity class. */
@Entity
data class Category(

    /** Returns categoryID. */
    @PrimaryKey val categoryID: Int,

    /** Returns category number. */
    val number: Int,

    /** Returns category name. */
    val name: String,

    /** Returns dateSavedToLocalDatabase. */
    var dateSavedToLocalDatabase: Date?
)
