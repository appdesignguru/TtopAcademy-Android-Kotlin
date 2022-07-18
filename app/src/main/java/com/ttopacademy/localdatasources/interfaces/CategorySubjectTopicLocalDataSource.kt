package com.ttopacademy.localdatasources.interfaces

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic

/** CategorySubjectTopic local data source interface. */
interface CategorySubjectTopicLocalDataSource {

    /** Checks whether categorySubjectTopic local data source is NOT up-to-date.  */
    fun isOutdated(): Boolean

    /** Returns categorySubjectTopicID for given parameters.  */
    fun getCategorySubjectTopicID(categorySubjectID: Int, topicID: Int): Int

    /** Returns all categorySubjectTopics.  */
    fun getCategorySubjectTopics(categorySubjectID: Int): MutableList<CategorySubjectTopic>

    /** Returns true after saving successfully.  */
    fun saveCategorySubjectTopics(categorySubjectTopics: MutableList<CategorySubjectTopic>): Boolean

    /** Returns true after deleting successfully.  */
    fun deleteAllCategorySubjectTopics(): Boolean
}