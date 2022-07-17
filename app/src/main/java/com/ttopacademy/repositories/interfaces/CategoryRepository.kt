package com.ttopacademy.repositories.interfaces

import com.ttopacademy.localdatasources.entities.Category

/** Repository interface for categories. */
interface CategoryRepository {

    /** Returns all categories.  */
    fun getAllCategories(): MutableList<Category>
}