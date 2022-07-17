package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey

/** CategoryResponse entity class. */
data class CategoryResponse(

    /** Returns categoryID. */
    @PrimaryKey val categoryID: Int,

    /** Returns category number. */
    val number: Int,

    /** Returns category name. */
    val name: String
)
