package com.ttopacademy.tests.localdatasources

import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.localdatasources.interfaces.VideoLocalDataSource
import com.ttopacademy.localdatasources.roomdb.VideoLocalDataSourceImpl
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeVideoDao
import com.ttopacademy.utilities.FakeDateTimeUtility
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class VideoLocalDataSourceTest {

    private lateinit var videoLocalDataSource: VideoLocalDataSource

    @Before
    fun initializeBeforeEachTest() {
        videoLocalDataSource = VideoLocalDataSourceImpl(FakeVideoDao(), FakeDateTimeUtility())

        // PreSave
        val videos: MutableList<Video> = mutableListOf()
        videos.add(Video(1, 1, "Video 1", "youtube 1", "10",
                "solution youtube 1", "10", Date()))
        videos.add(Video(2, 2, "Video 2", "youtube 2", "10",
                "solution youtube 2", "10", Date()))
        videoLocalDataSource.saveVideos(videos)
    }

    @Test
    fun hasOutdatedVideos_ShouldReturnTrueForGivenParameters() {
        val videoIDs: MutableList<Int> = mutableListOf()
        videoIDs.add(1)
        videoIDs.add(2)
        val result = videoLocalDataSource.hasOutdatedVideos(videoIDs)
        Assert.assertTrue(result)
    }

    @Test
    fun getVideos_ShouldReturnAllForGivenParameters() {
        val videoIDs: MutableList<Int> = mutableListOf()
        videoIDs.add(1)
        videoIDs.add(2)
        val result: List<Video> = videoLocalDataSource.getVideos(videoIDs)
        Assert.assertEquals(videoIDs.size, result.size)
    }

    @Test
    fun saveVideos_ShouldReturnTrueAfterSaving() {
        val videos: MutableList<Video> = mutableListOf()
        videos.add(Video(3, 3, "Video 3", "youtube 3", "10",
                "solution youtube 3", "10", Date()))
        val result = videoLocalDataSource.saveVideos(videos)
        Assert.assertTrue(result)
    }
}