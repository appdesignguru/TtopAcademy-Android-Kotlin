package com.ttopacademy.localdatasources.roomdb

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.interfaces.CategoryLocalDataSource
import com.ttopacademy.localdatasources.roomdb.dao.CategoryDao
import com.ttopacademy.utilities.DateTimeUtility
import java.util.*
import javax.inject.Inject

/** CategoryLocalDataSource implementation class.  */
class CategoryLocalDataSourceImpl @Inject constructor(
    private val categoryDao: CategoryDao,
    private val dateTimeUtility: DateTimeUtility
) : CategoryLocalDataSource {

    override fun isOutdated(): Boolean {
        val todaysDate = Date()
        val lastUpdated = categoryDao.getDateOfLastUpdate() ?: return true
        val dayDifference: Long = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated)
        return dayDifference > 1
    }

    override fun getAllCategories(): MutableList<Category> {
        return categoryDao.getAllCategories()
    }

    override fun saveCategories(categories: MutableList<Category>): Boolean {
        categoryDao.insertCategories(categories)
        return true
    }

    override fun deleteAllCategories(): Boolean {
        categoryDao.deleteAllCategories()
        return true
    }

}
