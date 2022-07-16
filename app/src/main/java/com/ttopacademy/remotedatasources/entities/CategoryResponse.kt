package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey

/** CategoryResponse entity class. */
data class CategoryResponse(
    @PrimaryKey val categoryID: Int,
    val number: Int,
    val name: String
)
