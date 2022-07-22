package com.ttopacademy.tests.managers

import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.managers.interfaces.TopicManager
import com.ttopacademy.managers.real.TopicManagerImpl
import com.ttopacademy.repositories.fakes.FakeCategorySubjectRepository
import com.ttopacademy.repositories.fakes.FakeCategorySubjectTopicRepository
import com.ttopacademy.repositories.fakes.FakeTopicRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TopicManagerTest {

    private lateinit var topicManager: TopicManager

    @Before
    fun initializeBeforeEachTest() {
        topicManager = TopicManagerImpl(
            FakeCategorySubjectRepository(), FakeCategorySubjectTopicRepository(),
            FakeTopicRepository()
        )
    }

    @Test
    fun getTopics_ShouldReturnTopicsForGivenParameters() {
        val categoryID = 1
        val subjectID = 1
        val result: List<Topic> = topicManager.getTopics(categoryID, subjectID)
        Assert.assertEquals(2, result.size)
    }
}