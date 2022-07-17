package com.ttopacademy.repositories.fakes

import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.repositories.interfaces.VideoRepository
import java.util.*
import javax.inject.Inject

/** Fake Video repository implementation class. Used for unit testing only. */
class FakeVideoRepostory @Inject constructor() : VideoRepository {

    override fun getVideos(categorySubjectTopicID: Int, videoIDs: MutableList<Int>): MutableList<Video> {
        val mockVideos: MutableList<Video> = mutableListOf()
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