package com.ttopacademy.localdatasources.fakes

import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.localdatasources.interfaces.VideoLocalDataSource
import javax.inject.Inject

/** Fake Video local data source implementation class. Used for unit testing only. */
class FakeVideoLocalDataSource @Inject constructor() : VideoLocalDataSource {

    private val videos: MutableList<Video> = mutableListOf()

    override fun hasOutdatedVideos(videoIDs: MutableList<Int>): Boolean {
        return true
    }

    override fun getVideos(videoIDs: MutableList<Int>): MutableList<Video> {
        val result: MutableList<Video> = mutableListOf()
        var video: Video?
        for (videoID in videoIDs) {
            video = getVideo(videoID)
            if (video != null) {
                result.add(video)
            }
        }
        return result
    }

    override fun saveVideos(videos: MutableList<Video>): Boolean {
        this.videos.clear()
        this.videos.addAll(videos)
        return true
    }

    private fun getVideo(videoID: Int): Video? {
        for (video in videos) {
            if (video.videoID == videoID) {
                return video
            }
        }
        return null
    }
}