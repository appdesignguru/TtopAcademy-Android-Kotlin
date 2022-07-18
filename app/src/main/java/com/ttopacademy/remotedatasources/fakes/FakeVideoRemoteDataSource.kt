package com.ttopacademy.remotedatasources.fakes

import com.ttopacademy.remotedatasources.entities.VideoResponse
import com.ttopacademy.remotedatasources.interfaces.VideoRemoteDataSource
import javax.inject.Inject

/** Fake Video remote data source implementation class. Used for unit testing only. */
class FakeVideoRemoteDataSource @Inject constructor() : VideoRemoteDataSource {

    override fun getVideos(categorySubjectTopicID: Int): Result<List<VideoResponse>> {
        val mockVideoResponses: MutableList<VideoResponse> = mutableListOf()
        mockVideoResponses.add(
            VideoResponse(
                1, 1, "Video 1", "youtube 1", "10",
                "solution youtube 1", "10"
            )
        )
        mockVideoResponses.add(
            VideoResponse(
                2, 1, "Video 2", "youtube 2", "10",
                "solution youtube 2", "10"
            )
        )


        return Result.success(mockVideoResponses)
    }
}