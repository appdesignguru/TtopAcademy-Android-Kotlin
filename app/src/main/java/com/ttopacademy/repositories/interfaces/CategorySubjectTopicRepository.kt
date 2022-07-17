package com.ttopacademy.repositories.interfaces

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic

/** Repository interface for CategorySubjectTopics. */
interface CategorySubjectTopicRepository {
    /** Returns categorySubjectTopicID.  */
    fun getCategorySubjectTopicID(categorySubjectID: Int, topicID: Int): Int

    /** Returns categorySubjectTopics for given parameter.  */
    fun getCategorySubjectTopics(categorySubjectID: Int): MutableList<CategorySubjectTopic>

}