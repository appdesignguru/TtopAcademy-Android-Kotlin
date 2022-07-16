package com.ttopacademy.localdatasources.entities

import androidx.room.PrimaryKey
import java.util.*

data class Category(
    @PrimaryKey val categoryID: Int,
    val number: Int,
    val name: String,
    val dateSavedToLocalDatabase: Date
)
