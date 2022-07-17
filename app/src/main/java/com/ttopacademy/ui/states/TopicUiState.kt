package com.ttopacademy.ui.states

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.entities.Topic

/** UI state for topic list screen. */
data class TopicUiState(

    /** Checks whether topics are currently being fetched. */
    val isFetchingTopics: Boolean,

    /** Returns all topics. */
    val topics: MutableList<Topic> = mutableListOf(),

    /** Returns selected category. */
    val selectedCategory: Category,

    /** Returns selected subject. */
    val selectedSubject: Subject,
)
