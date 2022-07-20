package com.ttopacademy.localdatasources.roomdb

import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.interfaces.TopicLocalDataSource
import com.ttopacademy.localdatasources.roomdb.dao.TopicDao
import com.ttopacademy.utilities.DateTimeUtility
import java.util.*
import javax.inject.Inject

/** TopicLocalDataSource implementation class.  */
class TopicLocalDataSourceImpl @Inject constructor(
    private val topicDao: TopicDao,
    private val dateTimeUtility: DateTimeUtility
) : TopicLocalDataSource {

    override fun isOutdated(): Boolean {
        val todaysDate = Date()
        val lastUpdated = topicDao.getDateOfLastUpdate() ?: return true
        val dayDifference: Long = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated)
        return dayDifference > 1
    }

    override fun getTopics(topicIDs: MutableList<Int>): MutableList<Topic> {
        return topicDao.getTopics(topicIDs)
    }

    override fun saveTopics(topics: MutableList<Topic>): Boolean {
        topicDao.insertTopics(topics)
        return true
    }

    override fun deleteAllTopics(): Boolean {
        topicDao.deleteAllTopics()
        return true
    }
}
