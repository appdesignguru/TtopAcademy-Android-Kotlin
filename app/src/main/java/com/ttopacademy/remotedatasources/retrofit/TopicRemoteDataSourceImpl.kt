package com.ttopacademy.remotedatasources.retrofit

import com.ttopacademy.remotedatasources.entities.TopicResponse
import com.ttopacademy.remotedatasources.interfaces.TopicRemoteDataSource
import retrofit2.Call
import javax.inject.Inject

/** TopicRemoteDataSource Implementation class.  */
class TopicRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
    ) : TopicRemoteDataSource {

    override fun getAllTopics(): Result<MutableList<TopicResponse>> {
        val apiCall: Call<MutableList<TopicResponse>> = apiService.allTopics
        return try {
            val topicResponses = apiCall.execute().body()!!
            Result.success(topicResponses)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return Result.failure(exception)
        }
    }
}