package com.ttopacademy.repositories.real

import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.interfaces.TopicLocalDataSource
import com.ttopacademy.remotedatasources.entities.TopicResponse
import com.ttopacademy.remotedatasources.interfaces.TopicRemoteDataSource
import com.ttopacademy.repositories.interfaces.TopicRepository
import java.util.*
import javax.inject.Inject

/** TopicRepository implementation class. */
class TopicRepositoryImpl @Inject constructor(
    private val topicLocalDataSource: TopicLocalDataSource,
    private val topicRemoteDataSource: TopicRemoteDataSource
) : TopicRepository {

    override fun getTopics(topicIDs: MutableList<Int>): MutableList<Topic> {
        if (topicLocalDataSource.isOutdated()) {
            refreshTopics()
        }
        return topicLocalDataSource.getTopics(topicIDs)
    }

    private fun refreshTopics() {
        val result: Result<MutableList<TopicResponse>> = topicRemoteDataSource.getAllTopics()
        if (result.isSuccess) {
            val topicResponses: MutableList<TopicResponse>? = result.getOrNull()
            if (topicResponses != null){
                updateTopicLocalDataSource(topicResponses)
            }
        }
    }

    private fun updateTopicLocalDataSource(topicResponses: MutableList<TopicResponse>) {
        topicLocalDataSource.deleteAllTopics()
        val topics: MutableList<Topic> = mutableListOf()
        val dateSavedToLocalDatabase = Date()
        for ((topicID, number, name) in topicResponses) {
            topics.add(Topic(topicID, number, name, dateSavedToLocalDatabase))
        }
        topicLocalDataSource.saveTopics(topics)
    }
}