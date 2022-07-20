package com.ttopacademy.localdatasources.roomdb

import com.ttopacademy.localdatasources.entities.CategorySubject
import com.ttopacademy.localdatasources.interfaces.CategorySubjectLocalDataSource
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectDao
import com.ttopacademy.utilities.DateTimeUtility
import java.util.*
import javax.inject.Inject

/** CategorySubjectLocalDataSource implementation class.  */
class CategorySubjectLocalDataSourceImpl @Inject constructor(
    private val categorySubjectDao: CategorySubjectDao,
    private val dateTimeUtility: DateTimeUtility
) : CategorySubjectLocalDataSource {

    override fun isOutdated(): Boolean {
        val todaysDate = Date()
        val lastUpdated = categorySubjectDao.getDateOfLastUpdate() ?: return true
        val dayDifference: Long = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated)
        return dayDifference > 1
    }

    override fun getCategorySubjects(categoryID: Int): MutableList<CategorySubject> {
        return categorySubjectDao.getCategorySubjects(categoryID)
    }

    override fun getCategorySubjectID(categoryID: Int, subjectID: Int): Int {
        return categorySubjectDao.getCategorySubjectID(categoryID, subjectID)
    }

    override fun saveCategorySubjects(categorySubjects: MutableList<CategorySubject>): Boolean {
        categorySubjectDao.insertCategorySubjects(categorySubjects)
        return true
    }

    override fun deleteAllCategorySubjects(): Boolean {
        categorySubjectDao.deleteAllCategorySubjects()
        return true
    }
}
