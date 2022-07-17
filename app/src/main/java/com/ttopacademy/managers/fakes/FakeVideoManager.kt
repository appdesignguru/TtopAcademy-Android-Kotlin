package com.ttopacademy.managers.fakes

import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.managers.interfaces.VideoManager
import java.util.*
import javax.inject.Inject

/** Fake Video Manager implementation class. Used for unit testing only. */
class FakeVideoManager @Inject constructor() : VideoManager {

    override fun getVideos(categoryID: Int, subjectID: Int, topicID: Int): MutableList<Video> {
        val mockVideos: MutableList<Video> = ArrayList()
        mockVideos.add(
            Video(
                1, 1, "Video 1", "youtube 1", "10",
                "solution youtube 1", "10", Date()
            )
        )
        mockVideos.add(
            Video(
                2, 1, "Video 2", "youtube 2", "10",
                "solution youtube 2", "10", Date()
            )
        )

        return mockVideos
    }
}