package com.ttopacademy.remotedatasources.interfaces

import com.ttopacademy.remotedatasources.entities.VideoResponse
/** Video remote data source interface. */
interface VideoRemoteDataSource {

    /** Returns video responses for given parameter.  */
    fun getVideos(categorySubjectTopicID: Int): Result<MutableList<VideoResponse>>
}