package com.ttopacademy.localdatasources.roomdb.fakedao

import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.roomdb.dao.TopicDao
import java.util.*
import javax.inject.Inject

/** Fake Topic DAO implementation class. Used for unit testing only.  */
class FakeTopicDao @Inject constructor() : TopicDao {

    private val topics: MutableList<Topic> = mutableListOf()

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

    override fun insertTopics(topics: MutableList<Topic>) {
        this.topics.addAll(topics)
    }

    override fun deleteAllTopics() {
        topics.clear()
    }

    override fun getDateOfLastUpdate(): Date? {
        return null
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
