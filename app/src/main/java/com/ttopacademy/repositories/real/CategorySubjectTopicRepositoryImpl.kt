package com.ttopacademy.repositories.real

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicLocalDataSource
import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicResponse
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicRemoteDataSource
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicRepository
import java.util.*
import javax.inject.Inject

/** CategorySubjectTopicRepository implementation class. */
class CategorySubjectTopicRepositoryImpl @Inject constructor(
    private val categorySubjectTopicLocalDataSource: CategorySubjectTopicLocalDataSource,
    private val categorySubjectTopicRemoteDataSource: CategorySubjectTopicRemoteDataSource
) : CategorySubjectTopicRepository {

    override fun getCategorySubjectTopicID(categorySubjectID: Int, topicID: Int): Int {
        if (categorySubjectTopicLocalDataSource.isOutdated()) {
            refreshCategorySubjectTopics()
        }
        return categorySubjectTopicLocalDataSource.getCategorySubjectTopicID(categorySubjectID,topicID)
    }

    override fun getCategorySubjectTopics(categorySubjectID: Int): MutableList<CategorySubjectTopic> {
        if (categorySubjectTopicLocalDataSource.isOutdated()) {
            refreshCategorySubjectTopics()
        }
        return categorySubjectTopicLocalDataSource.getCategorySubjectTopics(categorySubjectID)
    }

    private fun refreshCategorySubjectTopics() {
        val result: Result<MutableList<CategorySubjectTopicResponse>> =
            categorySubjectTopicRemoteDataSource.getAllCategorySubjectTopics()
        if (result.isSuccess) {
            val categorySubjectTopicResponses: MutableList<CategorySubjectTopicResponse>? = result.getOrNull()
            if (categorySubjectTopicResponses != null){
                updateCategorySubjectTopicLocalDataSource(categorySubjectTopicResponses)
            }
        }
    }

    private fun updateCategorySubjectTopicLocalDataSource(
        categorySubjectTopicResponses: MutableList<CategorySubjectTopicResponse>
    ) {
        categorySubjectTopicLocalDataSource.deleteAllCategorySubjectTopics()
        val categorySubjectTopics: MutableList<CategorySubjectTopic> = mutableListOf()
        val dateSavedToLocalDatabase = Date()
        for (categorySubjectTopicResponse in categorySubjectTopicResponses) {
            categorySubjectTopics.add(
                CategorySubjectTopic(
                    categorySubjectTopicResponse.categorySubjectTopicID,
                    categorySubjectTopicResponse.categorySubjectTopicID,
                    categorySubjectTopicResponse.topicID,
                    dateSavedToLocalDatabase
                )
            )
        }
        categorySubjectTopicLocalDataSource.saveCategorySubjectTopics(categorySubjectTopics)
    }
}