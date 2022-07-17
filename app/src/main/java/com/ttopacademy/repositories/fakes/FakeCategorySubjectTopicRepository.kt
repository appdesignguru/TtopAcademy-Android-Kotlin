package com.ttopacademy.repositories.fakes

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicRepository
import java.util.*
import javax.inject.Inject

/** Fake CategorySubject repository implementation class. Used for unit testing only. */
class FakeCategorySubjectTopicRepository @Inject constructor() : CategorySubjectTopicRepository {

    override fun getCategorySubjectTopicID(categorySubjectID: Int, topicID: Int): Int {
        return 1
    }

    override fun getCategorySubjectTopics(categorySubjectID: Int): MutableList<CategorySubjectTopic> {
        val mockCategorySubjectTopics: MutableList<CategorySubjectTopic> = mutableListOf()
        mockCategorySubjectTopics.add(
            CategorySubjectTopic(
                1, 1, 1, Date()
            )
        )
        mockCategorySubjectTopics.add(
            CategorySubjectTopic(
                2, 1, 2, Date()
            )
        )

        return mockCategorySubjectTopics
    }
}