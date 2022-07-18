package com.ttopacademy.remotedatasources.interfaces

import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicVideoResponse

/** CategorySubjectTopicVideo remote data source interface.  */
interface CategorySubjectTopicVideoRemoteDataSource {

    /** Returns CategorySubjectTopicVideo responses for given parameter.  */
    fun getCategorySubjectTopicVideos(
        categorySubjectTopicID: Int
    ): Result<MutableList<CategorySubjectTopicVideoResponse>>
}