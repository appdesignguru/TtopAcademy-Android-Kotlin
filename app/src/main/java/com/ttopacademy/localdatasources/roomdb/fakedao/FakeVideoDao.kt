package com.ttopacademy.localdatasources.roomdb.fakedao

import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.localdatasources.roomdb.dao.VideoDao
import java.util.*
import javax.inject.Inject

/** Fake Video DAO implementation class. Used for unit testing only.  */
class FakeVideoDao @Inject constructor() : VideoDao {

    private val videos: MutableList<Video> = mutableListOf()

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

    override fun insertVideos(videos: MutableList<Video>) {
        this.videos.addAll(videos)
    }

    override fun getDateOfLastUpdate(videoIDs: MutableList<Int>): Date? {
        return null
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
