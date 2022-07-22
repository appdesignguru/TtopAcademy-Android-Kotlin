package com.ttopacademy.tests.repositories

import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.localdatasources.fakes.FakeVideoLocalDataSource
import com.ttopacademy.remotedatasources.fakes.FakeVideoRemoteDataSource
import com.ttopacademy.repositories.interfaces.VideoRepository
import com.ttopacademy.repositories.real.VideoRepositoryImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class VideoRepositoryTest {

    private lateinit var videoRepository: VideoRepository

    @Before
    fun initializeBeforeEachTest() {
        videoRepository = VideoRepositoryImpl(
            FakeVideoLocalDataSource(), FakeVideoRemoteDataSource()
        )
    }

    @Test
    fun getVideos_ShouldReturnForGivenParameters() {
        val categorySubjectTopicID = 1
        val videoIDs: MutableList<Int> = ArrayList()
        videoIDs.add(1)
        videoIDs.add(2)
        val result: List<Video> = videoRepository.getVideos(categorySubjectTopicID, videoIDs)
        Assert.assertEquals(videoIDs.size, result.size)
    }
}