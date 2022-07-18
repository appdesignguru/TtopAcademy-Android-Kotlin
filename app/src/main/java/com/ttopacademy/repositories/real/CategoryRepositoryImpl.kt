package com.ttopacademy.repositories.real

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.interfaces.CategoryLocalDataSource
import com.ttopacademy.remotedatasources.entities.CategoryResponse
import com.ttopacademy.remotedatasources.interfaces.CategoryRemoteDataSource
import com.ttopacademy.repositories.interfaces.CategoryRepository
import java.util.*
import javax.inject.Inject

/** CategoryRepository Implementation class. */
class CategoryRepositoryImpl @Inject constructor(
    private val categoryLocalDataSource: CategoryLocalDataSource,
    private val categoryRemoteDataSource: CategoryRemoteDataSource
) : CategoryRepository {

    override fun getAllCategories(): MutableList<Category> {
        if (categoryLocalDataSource.isOutdated()) {
            refreshCategories()
        }
        return categoryLocalDataSource.getAllCategories()
    }

    private fun refreshCategories() {
        val result: Result<MutableList<CategoryResponse>> = categoryRemoteDataSource.getAllCategories()
        if (result.isSuccess) {
            val categoryResponses: MutableList<CategoryResponse>? = result.getOrNull()
            if (categoryResponses != null){
                updateCategoryLocalDataSource(categoryResponses)
            }
        }
    }

    private fun updateCategoryLocalDataSource(categoryResponses: MutableList<CategoryResponse>) {
        categoryLocalDataSource.deleteAllCategories()
        val categories: MutableList<Category> = mutableListOf()
        val dateSavedToLocalDatabase = Date()
        for ((categoryID, number, name) in categoryResponses) {
            categories.add(Category(categoryID, number,name, dateSavedToLocalDatabase)
            )
        }
        categoryLocalDataSource.saveCategories(categories)
    }
}