package com.ttopacademy.ui.states

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.entities.Video

/** UI state for video list screen. */
data class VideoUiState(
    val isFetchingVideos: Boolean,
    val videos: MutableList<Video> = mutableListOf(),
    val selectedCategory: Category,
    val selectedSubject: Subject,
    val selectedTopic: Topic,
)
