package com.ttopacademy.localdatasources.roomdb.fakedao

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectTopicDao
import java.util.*
import javax.inject.Inject

/** Fake CategorySubjectTopic dao implementation class. Used for unit testing only.  */
class FakeCategorySubjectTopicDao @Inject constructor() : CategorySubjectTopicDao {

    private val categorySubjectTopics: MutableList<CategorySubjectTopic> = mutableListOf()

    override fun getCategorySubjectTopics(categorySubjectID: Int): MutableList<CategorySubjectTopic> {
        val result: MutableList<CategorySubjectTopic> = mutableListOf()
        for (categorySubjectTopic in categorySubjectTopics) {
            if (categorySubjectTopic.categorySubjectID == categorySubjectID) {
                result.add(categorySubjectTopic)
            }
        }
        return result
    }

    override fun getCategorySubjectTopicID(categorySubjectID: Int, topicID: Int): Int {
        for (categorySubjectTopic in categorySubjectTopics) {
            if (categorySubjectTopic.categorySubjectID == categorySubjectID
                && categorySubjectTopic.topicID == topicID) {
                return categorySubjectTopic.categorySubjectTopicID
            }
        }
        return 0
    }

    override fun insertCategorySubjectTopics(categorySubjectTopics: MutableList<CategorySubjectTopic>) {
        this.categorySubjectTopics.addAll(categorySubjectTopics)
    }

    override fun deleteAllCategorySubjectTopics() {
        categorySubjectTopics.clear()
    }

    override fun getDateOfLastUpdate(): Date? {
        return null
    }
}
