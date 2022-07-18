package com.ttopacademy.remotedatasources.fakes

import com.ttopacademy.remotedatasources.entities.CategoryResponse
import com.ttopacademy.remotedatasources.interfaces.CategoryRemoteDataSource
import javax.inject.Inject

/** Fake Category remote data source implementation class. Used for unit testing only. */
class FakeCategoryRemoteDataSource @Inject constructor() : CategoryRemoteDataSource {

    override fun getAllCategories(): Result<MutableList<CategoryResponse>> {
        val mockCategoryResponses: MutableList<CategoryResponse> = mutableListOf()
        mockCategoryResponses.add(CategoryResponse(1, 1, "JAMB"))
        mockCategoryResponses.add(CategoryResponse(2, 2, "SS3"))

        return Result.success(mockCategoryResponses)
    }
}