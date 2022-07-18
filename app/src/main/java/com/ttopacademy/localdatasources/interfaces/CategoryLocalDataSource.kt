package com.ttopacademy.localdatasources.interfaces

import com.ttopacademy.localdatasources.entities.Category

/** Category local data source interface. */
interface CategoryLocalDataSource {

    /** Checks whether category local data source is up-to-date.  */
    fun isOutdated(): Boolean

    /** Returns all categories.  */
    fun getAllCategories(): MutableList<Category>

    /** Returns true after saving successfully.  */
    fun saveCategories(categories: MutableList<Category>): Boolean

    /** Returns true after deleting successfully.  */
    fun deleteAllCategories(): Boolean
}