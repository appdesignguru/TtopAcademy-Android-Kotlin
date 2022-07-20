package com.ttopacademy.localdatasources.roomdb.fakedao

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo
import com.ttopacademy.localdatasources.roomdb.dao.CategorySubjectTopicVideoDao
import java.util.*
import javax.inject.Inject

/** Fake CategorySubjectTopicVideo dao implementation class. Used for unit testing only.  */
class FakeCategorySubjectTopicVideoDao @Inject constructor() : CategorySubjectTopicVideoDao {

    private val categorySubjectTopicVideos: MutableList<CategorySubjectTopicVideo> = mutableListOf()

    override fun getCategorySubjectTopicVideos(categorySubjectTopicID: Int): MutableList<CategorySubjectTopicVideo> {
        val result: MutableList<CategorySubjectTopicVideo> = mutableListOf()
        for (categorySubjectTopicVideo in categorySubjectTopicVideos) {
            if (categorySubjectTopicVideo.categorySubjectTopicID == categorySubjectTopicID) {
                result.add(categorySubjectTopicVideo)
            }
        }
        return result
    }

    override fun getCategorySubjectTopicVideoID(categorySubjectTopicID: Int, videoID: Int): Int {
        for (categorySubjectTopicVideo in categorySubjectTopicVideos) {
            if (categorySubjectTopicVideo.categorySubjectTopicID == categorySubjectTopicID
                && categorySubjectTopicVideo.videoID == videoID
            ) {
                return categorySubjectTopicVideo.categorySubjectTopicVideoID
            }
        }
        return 0
    }

    override fun insertCategorySubjectTopicVideos(categorySubjectTopicVideos: MutableList<CategorySubjectTopicVideo>) {
        this.categorySubjectTopicVideos.clear()
        this.categorySubjectTopicVideos.addAll(categorySubjectTopicVideos)
    }

    override fun getDateOfLastUpdate(categorySubjectTopicID: Int): Date? {
        return null
    }
}
