package com.ttopacademy.remotedatasources.retrofit

import com.ttopacademy.remotedatasources.entities.CategorySubjectTopicResponse
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectTopicRemoteDataSource
import retrofit2.Call
import javax.inject.Inject

/** CategorySubjectTopicRemoteDataSource Implementation class.  */
class CategorySubjectTopicRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
    ) : CategorySubjectTopicRemoteDataSource {

    override fun getAllCategorySubjectTopics(): Result<MutableList<CategorySubjectTopicResponse>> {
        val apiCall: Call<MutableList<CategorySubjectTopicResponse>> = apiService.allCategorySubjectTopics
        return try {
            val categorySubjectTopicResponses = apiCall.execute().body()!!
            Result.success(categorySubjectTopicResponses)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return Result.failure(exception)
        }
    }
}