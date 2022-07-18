package com.ttopacademy.remotedatasources.fakes

import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicVideoResponse
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicVideoRemoteDataSource
import javax.inject.Inject

/** Fake CategorySubjectTopicVideo remote data source implementation class. Used for unit testing only. */
class FakeCategorySubjectTopicVideoRemoteDataSource @Inject constructor() :
    CategorySubjectTopicVideoRemoteDataSource {

    override fun getCategorySubjectTopicVideos(categorySubjectTopicID: Int): Result<List<CategorySubjectTopicVideoResponse>> {
        val mockCategorySubjectTopicVideoResponses: MutableList<CategorySubjectTopicVideoResponse> =
            mutableListOf()
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(1, 1, 1))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(2, 1, 2))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(3, 2, 1))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(4, 2, 2))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(5, 3, 1))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(6, 3, 2))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(7, 4, 1))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(8, 4, 2))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(9, 5, 1))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(10, 5, 2))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(11, 6, 1))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(12, 6, 2))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(13, 7, 1))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(14, 7, 2))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(15, 8, 1))
        mockCategorySubjectTopicVideoResponses.add(CategorySubjectTopicVideoResponse(16, 8, 2))

        return Result.success(mockCategorySubjectTopicVideoResponses)
    }
}