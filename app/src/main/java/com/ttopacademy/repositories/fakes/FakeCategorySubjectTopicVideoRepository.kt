package com.ttopacademy.repositories.fakes

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicVideoRepository
import java.util.*
import javax.inject.Inject

/** Fake CategorySubjectTopicVideo repository implementation class. Used for unit testing only. */
class FakeCategorySubjectTopicVideoRepository @Inject constructor() : CategorySubjectTopicVideoRepository {

    override fun getCategorySubjectTopicVideoID(categorySubjectTopicID: Int, videoID: Int): Int {
        return 8
    }

    override fun getCategorySubjectTopicVideos(categorySubjectTopicID: Int): MutableList<CategorySubjectTopicVideo> {
        val mockCategorySubjectTopicVideos: MutableList<CategorySubjectTopicVideo> = mutableListOf()
        mockCategorySubjectTopicVideos.add(
            CategorySubjectTopicVideo(
                1, 1, 1, Date()
            )
        )
        mockCategorySubjectTopicVideos.add(
            CategorySubjectTopicVideo(
                1, 1, 2, Date()
            )
        )

        return mockCategorySubjectTopicVideos
    }

}