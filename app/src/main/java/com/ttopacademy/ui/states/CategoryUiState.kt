package com.ttopacademy.ui.states

import com.ttopacademy.localdatasources.entities.Category

/** UI state for category list screen. */
data class CategoryUiState(
    val isFetchingCategories: Boolean,
    val categories: MutableList<Category> = mutableListOf()
)
