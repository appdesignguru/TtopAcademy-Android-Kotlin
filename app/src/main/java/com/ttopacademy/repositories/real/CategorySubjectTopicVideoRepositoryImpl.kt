package com.ttopacademy.repositories.real

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo
import com.ttopacademy.localdatasources.interfaces.CategorySubjectTopicVideoLocalDataSource
import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicVideoResponse
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicVideoRemoteDataSource
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicVideoRepository
import java.util.*
import javax.inject.Inject

/** CategorySubjectTopicVideoRepository Implementation class. */
class CategorySubjectTopicVideoRepositoryImpl @Inject constructor(
    private val categorySubjectTopicVideoLocalDataSource: CategorySubjectTopicVideoLocalDataSource,
    private val categorySubjectTopicVideoRemoteDataSource: CategorySubjectTopicVideoRemoteDataSource
) : CategorySubjectTopicVideoRepository {

    override fun getCategorySubjectTopicVideoID(categorySubjectTopicID: Int, videoID: Int): Int {
        if (categorySubjectTopicVideoLocalDataSource.hasOutdatedCategorySubjectTopicVideos(categorySubjectTopicID)
        ) {
            refreshCategorySubjectTopicVideos(categorySubjectTopicID)
        }
        return categorySubjectTopicVideoLocalDataSource.getCategorySubjectTopicVideoID(categorySubjectTopicID, videoID)
    }

    override fun getCategorySubjectTopicVideos(categorySubjectTopicID: Int): MutableList<CategorySubjectTopicVideo> {
        if (categorySubjectTopicVideoLocalDataSource.hasOutdatedCategorySubjectTopicVideos(categorySubjectTopicID)) {
            refreshCategorySubjectTopicVideos(categorySubjectTopicID)
        }
        return categorySubjectTopicVideoLocalDataSource.getCategorySubjectTopicVideos(categorySubjectTopicID)
    }

    private fun refreshCategorySubjectTopicVideos(categorySubjectTopicID: Int) {
        val result: Result<MutableList<CategorySubjectTopicVideoResponse>> =
            categorySubjectTopicVideoRemoteDataSource.getCategorySubjectTopicVideos(
                categorySubjectTopicID
            )
        if (result.isSuccess) {
            val categorySubjectTopicVideoResponses: MutableList<CategorySubjectTopicVideoResponse>?
                = result.getOrNull()
            if (categorySubjectTopicVideoResponses !== null){
                updateCategorySubjectTopicVideoLocalDataSource(categorySubjectTopicVideoResponses)
            }
        }
    }

    private fun updateCategorySubjectTopicVideoLocalDataSource(
        categorySubjectTopicVideoResponses: MutableList<CategorySubjectTopicVideoResponse>
    ) {
        val categorySubjectTopicVideos: MutableList<CategorySubjectTopicVideo> = ArrayList()
        val dateSavedToLocalDatabase = Date()
        for (categorySubjectTopicVideoResponse in categorySubjectTopicVideoResponses) {
            categorySubjectTopicVideos.add(
                CategorySubjectTopicVideo(
                    categorySubjectTopicVideoResponse.categorySubjectTopicVideoID,
                    categorySubjectTopicVideoResponse.categorySubjectTopiID,
                    categorySubjectTopicVideoResponse.videoID,
                    dateSavedToLocalDatabase
                )
            )
        }
        categorySubjectTopicVideoLocalDataSource.saveCategorySubjectTopicVideos(
            categorySubjectTopicVideos
        )
    }
}