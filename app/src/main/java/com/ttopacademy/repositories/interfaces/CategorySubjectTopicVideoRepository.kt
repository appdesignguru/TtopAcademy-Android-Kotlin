package com.ttopacademy.repositories.interfaces

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo

interface CategorySubjectTopicVideoRepository {

    /** Returns categorySubjectTopicVideoID.  */
    fun getCategorySubjectTopicVideoID(categorySubjectTopicID: Int, videoID: Int): Int

    /** Returns CategorySubjectTopicVideos.  */
    fun getCategorySubjectTopicVideos(categorySubjectTopicID: Int): MutableList<CategorySubjectTopicVideo>

}