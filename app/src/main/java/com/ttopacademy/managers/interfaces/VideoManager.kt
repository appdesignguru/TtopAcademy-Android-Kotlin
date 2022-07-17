package com.ttopacademy.managers.interfaces

import com.ttopacademy.localdatasources.entities.Video

/** Interface for managing videos. */
interface VideoManager {

    /** Returns the videos for given parameters.  */
    fun getVideos(categoryID: Int, subjectID: Int, topicID: Int): MutableList<Video>

}