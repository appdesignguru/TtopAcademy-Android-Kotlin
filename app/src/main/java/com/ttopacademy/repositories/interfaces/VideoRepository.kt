package com.ttopacademy.repositories.interfaces

import com.ttopacademy.localdatasources.entities.Video

/** Repository interface for topics. */
interface VideoRepository {

    /** Returns videos with given parameters.  */
    fun getVideos(categorySubjectTopicID: Int, videoIDs: MutableList<Int>): MutableList<Video>

}