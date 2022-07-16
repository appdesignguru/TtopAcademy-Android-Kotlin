package com.ttopacademy.ui.states

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.entities.Topic

/** UI state for topic list screen. */
data class TopicUiState(
    val isFetchingTopics: Boolean,
    val topics: List<Topic> = listOf(),
    val selectedCategory: Category,
    val selectedSubject: Subject,
)
