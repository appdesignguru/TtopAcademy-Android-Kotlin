package com.ttopacademy.ui.states

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.entities.Subject

/** UI state for subject list screen. */
data class SubjectUiState(
    val isFetchingSubjects: Boolean,
    val subjects: List<Subject> = listOf(),
    val selectedCategory: Category
)
