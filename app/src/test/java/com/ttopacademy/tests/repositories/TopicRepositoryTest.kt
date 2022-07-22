package com.ttopacademy.tests.repositories

import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.fakes.FakeTopicLocalDataSource
import com.ttopacademy.remotedatasources.fakes.FakeTopicRemoteDataSource
import com.ttopacademy.repositories.interfaces.TopicRepository
import com.ttopacademy.repositories.real.TopicRepositoryImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TopicRepositoryTest {

    private lateinit var topicRepository: TopicRepository

    @Before
    fun initializeBeforeEachTest() {
        topicRepository = TopicRepositoryImpl(
            FakeTopicLocalDataSource(), FakeTopicRemoteDataSource()
        )
    }

    @Test
    fun getTopics_ShouldReturnForGivenParameters() {
        val topicIDs: MutableList<Int> = ArrayList()
        topicIDs.add(1)
        topicIDs.add(2)
        val result: List<Topic> = topicRepository.getTopics(topicIDs)
        Assert.assertEquals(topicIDs.size, result.size)
    }
}