package com.ttopacademy.ui.states

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.entities.Video

/** UI state for video item screen. */
data class VideoItemUiState(

    /** Returns selected category. */
    val selectedCategory: Category,

    /** Returns selected subject. */
    val selectedSubject: Subject,

    /** Returns selected topic. */
    val selectedTopic: Topic,

    /** Returns selected video. */
    val selectedVideo: Video
)
