package com.ttopacademy.managers.fakes

import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.managers.interfaces.TopicManager
import java.util.*
import javax.inject.Inject

class FakeTopicManager @Inject constructor() : TopicManager {

    override fun getTopics(categoryID: Int, subjectID: Int): MutableList<Topic> {
        val mockTopics: MutableList<Topic> = ArrayList()
        mockTopics.add(Topic(1, 1, "Topic 1", Date()))
        mockTopics.add(Topic(2, 2, "Topic 2", Date()))

        return mockTopics
    }
}