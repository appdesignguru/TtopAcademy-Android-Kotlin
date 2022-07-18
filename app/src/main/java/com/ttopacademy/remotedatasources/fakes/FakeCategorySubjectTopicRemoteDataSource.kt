package com.ttopacademy.remotedatasources.fakes

import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicResponse
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicRemoteDataSource
import javax.inject.Inject

/** Fake CategorySubjectTopic remote data source implementation class. Used for unit testing only. */
class FakeCategorySubjectTopicRemoteDataSource @Inject constructor()
    : CategorySubjectTopicRemoteDataSource {

    override fun getAllCategorySubjectTopics(): Result<MutableList<CategorySubjectTopicResponse>> {
        val mockCategorySubjectTopicResponses: MutableList<CategorySubjectTopicResponse> =
            mutableListOf()
        mockCategorySubjectTopicResponses.add(CategorySubjectTopicResponse(1, 1, 1))
        mockCategorySubjectTopicResponses.add(CategorySubjectTopicResponse(2, 1, 2))
        mockCategorySubjectTopicResponses.add(CategorySubjectTopicResponse(3, 2, 1))
        mockCategorySubjectTopicResponses.add(CategorySubjectTopicResponse(4, 2, 2))
        mockCategorySubjectTopicResponses.add(CategorySubjectTopicResponse(5, 3, 1))
        mockCategorySubjectTopicResponses.add(CategorySubjectTopicResponse(6, 3, 2))
        mockCategorySubjectTopicResponses.add(CategorySubjectTopicResponse(7, 4, 1))
        mockCategorySubjectTopicResponses.add(CategorySubjectTopicResponse(8, 4, 2))

        return Result.success(mockCategorySubjectTopicResponses)

    }
}