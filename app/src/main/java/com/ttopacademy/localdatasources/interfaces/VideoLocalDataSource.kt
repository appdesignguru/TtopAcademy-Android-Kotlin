package com.ttopacademy.localdatasources.interfaces

import com.ttopacademy.localdatasources.entities.Video

/** Video local data source interface. */
interface VideoLocalDataSource {

    /** Checks whether Video local data source is NOT up-to-date for given parameter.  */
    fun hasOutdatedVideos(videoIDs: MutableList<Int>): Boolean

    /** Returns videos with given parameters.  */
    fun getVideos(videoIDs: MutableList<Int>): MutableList<Video>

    /** Returns true after saving successfully.  */
    fun saveVideos(videos: MutableList<Video>): Boolean
}