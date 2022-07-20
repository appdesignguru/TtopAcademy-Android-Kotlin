package com.ttopacademy.localdatasources.roomdb

import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.localdatasources.interfaces.VideoLocalDataSource
import com.ttopacademy.localdatasources.roomdb.dao.VideoDao
import com.ttopacademy.utilities.DateTimeUtility
import java.util.*
import javax.inject.Inject

/** VideoLocalDataSource implementation class.  */
class VideoLocalDataSourceImpl @Inject constructor(
    private val videoDao: VideoDao,
    private val dateTimeUtility: DateTimeUtility
) :
    VideoLocalDataSource {

    override fun hasOutdatedVideos(videoIDs: MutableList<Int>): Boolean {
        val todaysDate = Date()
        val lastUpdated = videoDao.getDateOfLastUpdate(videoIDs) ?: return true
        val dayDifference: Long = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated)
        return dayDifference > 1
    }

    override fun getVideos(videoIDs: MutableList<Int>): MutableList<Video> {
        return videoDao.getVideos(videoIDs)
    }

    override fun saveVideos(videos: MutableList<Video>): Boolean {
        videoDao.insertVideos(videos)
        return true
    }
}
