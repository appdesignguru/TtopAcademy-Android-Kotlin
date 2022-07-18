package com.ttopacademy.localdatasources.fakes

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicLocalDataSource
import javax.inject.Inject

/** Fake CategorySubjectTopic local data source implementation class. Used for unit testing only. */
class FakeCategorySubjectTopicLocalDataSource @Inject constructor() :
    CategorySubjectTopicLocalDataSource {

    private val categorySubjectTopics: MutableList<CategorySubjectTopic> = mutableListOf()
    private var outdated = true

    override fun isOutdated(): Boolean {
        return outdated
    }

    override fun getCategorySubjectTopicID(categorySubjectID: Int, topicID: Int): Int {
        for (categorySubjectTopic in categorySubjectTopics) {
            if (categorySubjectTopic.categorySubjectID == categorySubjectID
                && categorySubjectTopic.topicID == topicID
            ) {
                return categorySubjectTopic.categorySubjectTopicID
            }
        }
        return 0
    }

    override fun getCategorySubjectTopics(categorySubjectID: Int): MutableList<CategorySubjectTopic> {
        val result: MutableList<CategorySubjectTopic> = mutableListOf()
        for (categorySubjectTopic in categorySubjectTopics) {
            if (categorySubjectTopic.categorySubjectID == categorySubjectID) {
                result.add(categorySubjectTopic)
            }
        }
        return result
    }

    override fun saveCategorySubjectTopics(categorySubjectTopics: MutableList<CategorySubjectTopic>): Boolean {
        this.categorySubjectTopics.clear()
        this.categorySubjectTopics.addAll(categorySubjectTopics)
        outdated = false
        return true
    }

    override fun deleteAllCategorySubjectTopics(): Boolean {
        categorySubjectTopics.clear()
        outdated = true
        return false
    }
}