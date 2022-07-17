package com.ttopacademy.ui.states

import com.ttopacademy.localdatasources.entities.Category

/** UI state for category list screen. */
data class CategoryUiState(

    /** Checks whether categories are currently being fetched. */
    val isFetchingCategories: Boolean,

    /** Returns all categories. */
    val categories: MutableList<Category> = mutableListOf()
)
