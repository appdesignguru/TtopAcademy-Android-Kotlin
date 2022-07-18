package com.ttopacademy.repositories.real

import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.localdatasources.interfaces.VideoLocalDataSource
import com.ttopacademy.remotedatasources.entities.VideoResponse
import com.ttopacademy.remotedatasources.interfaces.VideoRemoteDataSource
import com.ttopacademy.repositories.interfaces.VideoRepository
import java.util.*
import javax.inject.Inject

/** VideoRepository implementation class. */
class VideoRepositoryImpl @Inject constructor(
    private val videoLocalDataSource: VideoLocalDataSource,
    private val videoRemoteDataSource: VideoRemoteDataSource
) : VideoRepository {

    override fun getVideos(categorySubjectTopicID: Int, videoIDs: MutableList<Int>
    ): MutableList<Video> {
        if (videoLocalDataSource.hasOutdatedVideos(videoIDs)) {
            refreshVideos(categorySubjectTopicID)
        }
        return videoLocalDataSource.getVideos(videoIDs)
    }

    private fun refreshVideos(categorySubjectTopicID: Int) {
        val result: Result<MutableList<VideoResponse>> =
            videoRemoteDataSource.getVideos(categorySubjectTopicID)
        if (result.isSuccess) {
            val videoResponses: MutableList<VideoResponse>? = result.getOrNull()
            if (videoResponses != null){
                updateVideoLocalDataSource(videoResponses)
            }
        }
    }

    private fun updateVideoLocalDataSource(videoResponses: MutableList<VideoResponse>) {
        val videos: MutableList<Video> = mutableListOf()
        val dateSavedToLocalDatabase = Date()
        for ((videoID, number, title, youtubeID, size, solutionVideoYoutubeID, solutionVideoSize) in videoResponses) {
            videos.add(
                Video(videoID, number, title, youtubeID, size, solutionVideoYoutubeID,
                      solutionVideoSize, dateSavedToLocalDatabase)
            )
        }
        videoLocalDataSource.saveVideos(videos)
    }
}