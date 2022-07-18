package com.ttopacademy.remotedatasources.fakes

import com.ttopacademy.remotedatasources.entities.CategorySubjectResponse
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectRemoteDataSource
import javax.inject.Inject

/** Fake CategorySubject remote data source implementation class. Used for unit testing only. */
class FakeCategorySubjectRemoteDataSource @Inject constructor()
    : CategorySubjectRemoteDataSource {

    override fun getAllCategorySubjects(): Result<MutableList<CategorySubjectResponse>> {
        val mockCategorySubjectResponses: MutableList<CategorySubjectResponse> = mutableListOf()
        mockCategorySubjectResponses.add(CategorySubjectResponse(1, 1, 1))
        mockCategorySubjectResponses.add(CategorySubjectResponse(2, 1, 2))
        mockCategorySubjectResponses.add(CategorySubjectResponse(3, 2, 1))
        mockCategorySubjectResponses.add(CategorySubjectResponse(4, 2, 2))

        return Result.success(mockCategorySubjectResponses)
    }
}