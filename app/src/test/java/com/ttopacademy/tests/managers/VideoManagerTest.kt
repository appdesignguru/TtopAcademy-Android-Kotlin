package com.ttopacademy.tests.managers

import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.managers.interfaces.VideoManager
import com.ttopacademy.managers.real.VideoManagerImpl
import com.ttopacademy.repositories.fakes.FakeCategorySubjectRepository
import com.ttopacademy.repositories.fakes.FakeCategorySubjectTopicRepository
import com.ttopacademy.repositories.fakes.FakeCategorySubjectTopicVideoRepository
import com.ttopacademy.repositories.fakes.FakeVideoRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class VideoManagerTest {

    private lateinit var videoManager: VideoManager

    @Before
    fun initializeBeforeEachTest() {
        videoManager = VideoManagerImpl(
            FakeCategorySubjectRepository(), FakeCategorySubjectTopicRepository(),
            FakeCategorySubjectTopicVideoRepository(), FakeVideoRepository(),
        )
    }

    @Test
    fun getVideos_ShouldReturnTopicsForGivenParameters() {
        val categoryID = 1
        val subjectID = 1
        val topicID = 1
        val result: List<Video> = videoManager.getVideos(categoryID, subjectID, topicID)
        Assert.assertEquals(2, result.size)
    }
}