package com.ttopacademy.remotedatasources.retrofit

import com.ttopacademy.remotedatasources.entities.VideoResponse
import com.ttopacademy.remotedatasources.interfaces.VideoRemoteDataSource
import retrofit2.Call
import javax.inject.Inject

/** VideoRemoteDataSource Implementation class.  */
class VideoRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
    ) : VideoRemoteDataSource {

    override fun getVideos(categorySubjectTopicID: Int): Result<MutableList<VideoResponse>> {
        val apiCall: Call<MutableList<VideoResponse>> = apiService.getVideos(categorySubjectTopicID)
        return try {
            val videoResponses = apiCall.execute().body()!!
            Result.success(videoResponses)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return Result.failure(exception)
        }
    }
}