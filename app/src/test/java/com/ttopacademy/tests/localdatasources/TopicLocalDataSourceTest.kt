package com.ttopacademy.tests.localdatasources

import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.interfaces.TopicLocalDataSource
import com.ttopacademy.localdatasources.roomdb.TopicLocalDataSourceImpl
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeTopicDao
import com.ttopacademy.utilities.FakeDateTimeUtility
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class TopicLocalDataSourceTest {

    private lateinit var topicLocalDataSource: TopicLocalDataSource

    @Before
    fun initializeBeforeEachTest() {
        topicLocalDataSource = TopicLocalDataSourceImpl(FakeTopicDao(), FakeDateTimeUtility())

        // PreSave
        val topics: MutableList<Topic> = ArrayList()
        topics.add(Topic(1, 1, "Title 1", Date()))
        topics.add(Topic(2, 2, "Title 2", Date()))
        topicLocalDataSource.saveTopics(topics)
    }

    @Test
    fun isOutdated_ShouldReturnTrue() {
        val result = topicLocalDataSource.isOutdated()
        Assert.assertTrue(result)
    }

    @Test
    fun getTopics_ShouldReturnAllForGivenParameters() {
        val topicIDs: MutableList<Int> = ArrayList()
        topicIDs.add(1)
        topicIDs.add(2)
        val result: List<Topic> = topicLocalDataSource.getTopics(topicIDs)
        Assert.assertEquals(topicIDs.size, result.size)
    }

    @Test
    fun saveTopics_ShouldReturnTrueAfterSaving() {
        val topics: MutableList<Topic> = ArrayList()
        topics.add(Topic(3, 3, "Topic 3", Date()))
        val result = topicLocalDataSource.saveTopics(topics)
        Assert.assertTrue(result)
    }

    @Test
    fun deleteAllTopics_ShouldReturnTrueAfterDeleting() {
        val result = topicLocalDataSource.deleteAllTopics()
        Assert.assertTrue(result)
    }
}