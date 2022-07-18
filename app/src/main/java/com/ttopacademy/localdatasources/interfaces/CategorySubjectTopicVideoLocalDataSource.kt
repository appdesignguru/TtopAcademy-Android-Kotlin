package com.ttopacademy.localdatasources.interfaces

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo

/** CategorySubjectTopicVideo local data source interface. */
interface CategorySubjectTopicVideoLocalDataSource {

    /** Checks whether CategorySubjectTopicVideo local data source is NOT up-to-date for given parameter.  */
    fun hasOutdatedCategorySubjectTopicVideos(categorySubjectTopicID: Int): Boolean

    /** Returns CategorySubjectTopicVideoID for given parameters.  */
    fun getCategorySubjectTopicVideoID(categorySubjectTopicID: Int, videoID: Int): Int

    /** Returns all CategorySubjectTopicVideos.  */
    fun getCategorySubjectTopicVideos(categorySubjectTopicID: Int): MutableList<CategorySubjectTopicVideo>

    /** Returns true after saving successfully.  */
    fun saveCategorySubjectTopicVideos(
        categorySubjectTopicVideos: MutableList<CategorySubjectTopicVideo>
    ): Boolean

}