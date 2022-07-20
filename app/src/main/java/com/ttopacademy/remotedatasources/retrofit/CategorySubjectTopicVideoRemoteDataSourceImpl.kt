package com.ttopacademy.remotedatasources.retrofit

import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicVideoResponse
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicVideoRemoteDataSource
import javax.inject.Inject

/** CategorySubjectTopicVideoRemoteDataSource Implementation class.  */
class CategorySubjectTopicVideoRemoteDataSourceImpl  @Inject constructor(
    private val apiService: ApiService
    ) : CategorySubjectTopicVideoRemoteDataSource {

    override fun getCategorySubjectTopicVideos(
        categorySubjectTopicID: Int
    ): Result<MutableList<CategorySubjectTopicVideoResponse>> {
        val apiCall = apiService.getCategorySubjectTopicVideos(categorySubjectTopicID)
        return try {
            val categorySubjectTopicVideoResponses = apiCall.execute().body()!!
            Result.success(categorySubjectTopicVideoResponses)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return Result.failure(exception)
        }
    }
}