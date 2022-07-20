package com.ttopacademy.localdatasources.roomdb

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicVideoLocalDataSource
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectTopicVideoDao
import com.ttopacademy.utilities.DateTimeUtility
import java.util.*
import javax.inject.Inject

/** CategorySubjectTopicVideoLocalDataSource implementation class.  */
class CategorySubjectTopicVideoLocalDataSourceImpl @Inject constructor(
    private val categorySubjectTopicVideoDao: CategorySubjectTopicVideoDao,
    private val dateTimeUtility: DateTimeUtility
) : CategorySubjectTopicVideoLocalDataSource {

    override fun hasOutdatedCategorySubjectTopicVideos(categorySubjectTopicID: Int): Boolean {
        val todaysDate = Date()
        val lastUpdated = categorySubjectTopicVideoDao.getDateOfLastUpdate(categorySubjectTopicID)
            ?: return true
        val dayDifference: Long = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated)
        return dayDifference > 1
    }

    override fun getCategorySubjectTopicVideoID(categorySubjectTopicID: Int, videoID: Int): Int {
        return categorySubjectTopicVideoDao.getCategorySubjectTopicVideoID(
            categorySubjectTopicID,
            videoID
        )
    }

    override fun getCategorySubjectTopicVideos(categorySubjectTopicID: Int): MutableList<CategorySubjectTopicVideo> {
        return categorySubjectTopicVideoDao.getCategorySubjectTopicVideos(categorySubjectTopicID)
    }

    override fun saveCategorySubjectTopicVideos(categorySubjectTopicVideos: MutableList<CategorySubjectTopicVideo>): Boolean {
        categorySubjectTopicVideoDao.insertCategorySubjectTopicVideos(categorySubjectTopicVideos)
        return true
    }
}
