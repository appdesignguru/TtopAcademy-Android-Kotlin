package com.ttopacademy.remotedatasources.fakes

import com.ttopacademy.remotedatasources.entities.TopicResponse
import com.ttopacademy.remotedatasources.interfaces.TopicRemoteDataSource
import javax.inject.Inject

/** Fake Topic remote data source implementation class. Used for unit testing only. */
class FakeTopicRemoteDataSource @Inject constructor() : TopicRemoteDataSource {

    override fun getAllTopics(): Result<List<TopicResponse>> {
        val mockTopicResponses: MutableList<TopicResponse> = mutableListOf()
        mockTopicResponses.add(TopicResponse(1, 1, "Topic 1"))
        mockTopicResponses.add(TopicResponse(2, 2, "Topic 2"))

        return Result.success(mockTopicResponses)
    }
}