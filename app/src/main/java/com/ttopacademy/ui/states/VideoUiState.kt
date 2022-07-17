package com.ttopacademy.ui.states

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.entities.Video

/** UI state for video list screen. */
data class VideoUiState(

    /** Checks whether videos are currently being fetched. */
    val isFetchingVideos: Boolean,

    /** Returns all videos. */
    val videos: MutableList<Video> = mutableListOf(),

    /** Returns selected category. */
    val selectedCategory: Category,

    /** Returns selected subject. */
    val selectedSubject: Subject,

    /** Returns selected topic. */
    val selectedTopic: Topic
)
