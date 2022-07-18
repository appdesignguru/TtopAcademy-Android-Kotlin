package com.ttopacademy.remotedatasources.interfaces

import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicResponse

/** CategorySubjectTopic remote data source interface.  */
interface CategorySubjectTopicRemoteDataSource {

    /** Returns CategorySubjectTopic responses.  */
    fun getAllCategorySubjectTopics(): Result<MutableList<CategorySubjectTopicResponse>>

}