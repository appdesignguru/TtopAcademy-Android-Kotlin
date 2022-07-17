package com.ttopacademy.repositories.fakes

import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.repositories.interfaces.TopicRepository
import java.util.*
import javax.inject.Inject

/** Fake Topic repository implementation class. Used for unit testing only.  */
class FakeTopicRepository @Inject constructor() : TopicRepository {

    override fun getTopics(topicIDs: MutableList<Int>): MutableList<Topic> {
        val mockTopics: MutableList<Topic> = mutableListOf()
        mockTopics.add(Topic(1, 1, "Topic 1", Date()))
        mockTopics.add(Topic(2, 2, "Topic 2", Date()))

        return mockTopics
    }
}