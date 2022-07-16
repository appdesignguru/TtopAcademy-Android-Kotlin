package com.ttopacademy.ui.states

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion

/** UI state for practice question list screen. */
data class PracticeQuestionUiState(
    val isFetchingPracticeQuestions: Boolean,
    val practiceQuestions: List<PracticeQuestion> = listOf(),
    val selectedCategory: Category,
    val selectedSubject: Subject,
    val selectedTopic: Topic,
    val selectedVideo: Video
)
