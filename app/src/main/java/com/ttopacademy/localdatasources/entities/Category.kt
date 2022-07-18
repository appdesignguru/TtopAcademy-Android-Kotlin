package com.ttopacademy.localdatasources.entities

import androidx.room.PrimaryKey
import java.util.*

/** Category entity class. */
data class Category(

    /** Returns categoryID. */
    @PrimaryKey val categoryID: Int,

    /** Returns category number. */
    val number: Int,

    /** Returns category name. */
    val name: String,

    /** Returns dateSavedToLocalDatabase. */
    val dateSavedToLocalDatabase: Date
)
