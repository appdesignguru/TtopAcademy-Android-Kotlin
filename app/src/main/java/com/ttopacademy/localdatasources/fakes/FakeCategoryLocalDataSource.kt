package com.ttopacademy.localdatasources.fakes

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.interfaces.CategoryLocalDataSource
import javax.inject.Inject

/** Fake Category local data source implementation class. Used for unit testing only. */
class FakeCategoryLocalDataSource @Inject constructor() : CategoryLocalDataSource {

    private val categories: MutableList<Category> = mutableListOf()
    private var outdated: Boolean = true

    override fun isOutdated(): Boolean {
        return outdated
    }

    override fun getAllCategories(): MutableList<Category> {
        return categories
    }

    override fun saveCategories(categories: MutableList<Category>): Boolean {
        this.categories.clear()
        this.categories.addAll(categories)
        outdated = false
        return true
    }

    override fun deleteAllCategories(): Boolean {
        categories.clear()
        outdated = true
        return true
    }
}