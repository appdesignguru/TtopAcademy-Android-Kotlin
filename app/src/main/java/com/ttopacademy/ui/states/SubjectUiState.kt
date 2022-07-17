package com.ttopacademy.ui.states

import com.ttopacademy.localdatasources.entities.Category
import com.ttopacademy.localdatasources.entities.Subject

/** UI state for subject list screen. */
data class SubjectUiState(

    /** Checks whether subjects are currently being fetched. */
    val isFetchingSubjects: Boolean,

    /** Returns all subjects. */
    val subjects: MutableList<Subject> = mutableListOf(),

    /** Returns selected category. */
    val selectedCategory: Category
)
