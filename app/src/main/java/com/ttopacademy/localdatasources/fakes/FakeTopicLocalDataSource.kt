package com.ttopacademy.localdatasources.fakes

import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.interfaces.TopicLocalDataSource
import javax.inject.Inject

/** Fake Topic local data source implementation class. Used for unit testing only. */
class FakeTopicLocalDataSource @Inject constructor() : TopicLocalDataSource {

    private val topics: MutableList<Topic> = mutableListOf()
    private var outdated = true

    override fun isOutdated(): Boolean {
        return true
    }

    override fun getTopics(topicIDs: MutableList<Int>): MutableList<Topic> {
        val result: MutableList<Topic> = mutableListOf()
        var topic: Topic?
        for (topicID in topicIDs) {
            topic = getTopic(topicID)
            if (topic != null) {
                result.add(topic)
            }
        }
        return result
    }

    override fun saveTopics(topics: MutableList<Topic>): Boolean {
        this.topics.clear()
        this.topics.addAll(topics)
        outdated = false
        return false
    }

    override fun deleteAllTopics(): Boolean {
        topics.clear()
        outdated = true
        return true
    }

    private fun getTopic(topicD: Int): Topic? {
        for (topic in topics) {
            if (topic.topicID == topicD) {
                return topic
            }
        }
        return null
    }
}