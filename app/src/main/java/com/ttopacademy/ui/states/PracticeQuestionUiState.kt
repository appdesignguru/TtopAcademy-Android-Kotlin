package com.ttopacademy.ui.states

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.entities.Subject
import com.ttopacademy.localdatasources.entities.Topic
import com.ttopacademy.localdatasources.entities.Video
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion

/** UI state for practice question list screen. */
data class PracticeQuestionUiState(

    /** Checks whether practice questions are currently being fetched. */
    val isFetchingPracticeQuestions: Boolean,

    /** Returns all practice questions. */
    val practiceQuestions: MutableList<PracticeQuestion> = mutableListOf(),

    /** Returns selected category. */
    val selectedCategory: Category,

    /** Returns selected subject. */
    val selectedSubject: Subject,

    /** Returns selected topic. */
    val selectedTopic: Topic,

    /** Returns selected video. */
    val selectedVideo: Video
)
