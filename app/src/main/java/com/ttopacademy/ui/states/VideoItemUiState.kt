package com.ttopacademy.ui.states

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.entities.Video

/** UI state for video item screen. */
data class VideoItemUiState(
    val selectedCategory: Category,
    val selectedSubject: Subject,
    val selectedTopic: Topic,
    val selectedVideo: Video
)
