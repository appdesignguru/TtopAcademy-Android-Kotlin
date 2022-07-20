package com.ttopacademy.localdatasources.roomdb

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicLocalDataSource
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectTopicDao
import com.ttopacademy.utilities.DateTimeUtility
import java.util.*
import javax.inject.Inject

/** CategorySubjectTopicLocalDataSource implementation class.  */
class CategorySubjectTopicLocalDataSourceImpl @Inject constructor(
    private val categorySubjectTopicDao: CategorySubjectTopicDao,
    private val dateTimeUtility: DateTimeUtility
) : CategorySubjectTopicLocalDataSource {

    override fun isOutdated(): Boolean {
        val todaysDate = Date()
        val lastUpdated = categorySubjectTopicDao.getDateOfLastUpdate() ?: return true
        val dayDifference: Long = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated)
        return dayDifference > 1
    }

    override fun getCategorySubjectTopicID(categorySubjectID: Int, topicID: Int): Int {
        return categorySubjectTopicDao.getCategorySubjectTopicID(categorySubjectID, topicID)
    }

    override fun getCategorySubjectTopics(categorySubjectID: Int): MutableList<CategorySubjectTopic> {
        return categorySubjectTopicDao.getCategorySubjectTopics(categorySubjectID)
    }

    override fun saveCategorySubjectTopics(categorySubjectTopics: MutableList<CategorySubjectTopic>): Boolean {
        categorySubjectTopicDao.insertCategorySubjectTopics(categorySubjectTopics)
        return true
    }

    override fun deleteAllCategorySubjectTopics(): Boolean {
        categorySubjectTopicDao.deleteAllCategorySubjectTopics()
        return true
    }
}
