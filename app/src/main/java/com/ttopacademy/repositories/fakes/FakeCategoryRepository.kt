package com.ttopacademy.repositories.fakes

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.repositories.interfaces.CategoryRepository
import java.util.*
import javax.inject.Inject

/** Fake Category repository implementation class. Used for unit testing only. */
class FakeCategoryRepository @Inject constructor() : CategoryRepository {

    override fun getAllCategories(): MutableList<Category> {
        val categories: MutableList<Category> = mutableListOf()
        categories.add(Category(1, 1, "JAMB", Date()))
        categories.add(Category(2, 2, "SS3", Date()))

        return categories
    }
}