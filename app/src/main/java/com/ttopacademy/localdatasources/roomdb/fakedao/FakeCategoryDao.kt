package com.ttopacademy.localdatasources.roomdb.fakedao

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.roomdb.dao.CategoryDao
import java.util.*
import javax.inject.Inject

/** Fake Category dao implementation class. Used for unit testing only.  */
class FakeCategoryDao @Inject constructor() : CategoryDao {

    private val categories: MutableList<Category> = mutableListOf()

    override fun getAllCategories(): MutableList<Category> {
        return categories
    }

    override fun insertCategories(categories: MutableList<Category>) {
        this.categories.addAll(categories)
    }

    override fun deleteAllCategories() {
        categories.clear()
    }

    override fun getDateOfLastUpdate(): Date? {
        return null
    }
}