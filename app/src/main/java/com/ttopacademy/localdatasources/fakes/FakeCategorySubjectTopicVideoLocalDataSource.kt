package com.ttopacademy.localdatasources.fakes

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicVideoLocalDataSource
import javax.inject.Inject

/** Fake CategorySubjectTopicVideo local data source implementation class. Used for unit testing only. */
class FakeCategorySubjectTopicVideoLocalDataSource @Inject constructor() :
    CategorySubjectTopicVideoLocalDataSource {

    private val categorySubjectTopicVideos: MutableList<CategorySubjectTopicVideo> = mutableListOf()

    override fun hasOutdatedCategorySubjectTopicVideos(categorySubjectTopicID: Int): Boolean {
        return true
    }

    override fun getCategorySubjectTopicVideoID(categorySubjectTopicID: Int, videoID: Int): Int {
        for (categorySubjectTopicVideo in categorySubjectTopicVideos) {
            if (categorySubjectTopicVideo.categorySubjectTopiID == categorySubjectTopicID
                && categorySubjectTopicVideo.videoID == videoID
            ) {
                return categorySubjectTopicVideo.categorySubjectTopicVideoID
            }
        }
        return 0
    }

    override fun getCategorySubjectTopicVideos(categorySubjectTopicID: Int): MutableList<CategorySubjectTopicVideo> {
        val result: MutableList<CategorySubjectTopicVideo> = mutableListOf()
        for (categorySubjectTopicVideo in categorySubjectTopicVideos) {
            if (categorySubjectTopicVideo.categorySubjectTopiID == categorySubjectTopicID) {
                result.add(categorySubjectTopicVideo)
            }
        }
        return result
    }

    override fun saveCategorySubjectTopicVideos(categorySubjectTopicVideos: MutableList<CategorySubjectTopicVideo>): Boolean {
        this.categorySubjectTopicVideos.clear()
        this.categorySubjectTopicVideos.addAll(categorySubjectTopicVideos)
        return true
    }
}