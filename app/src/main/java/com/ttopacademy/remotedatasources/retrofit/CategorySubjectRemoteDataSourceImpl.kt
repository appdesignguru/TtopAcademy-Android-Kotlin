package com.ttopacademy.remotedatasources.retrofit

import com.ttopacademy.remotedatasources.entities.CategorySubjectResponse
import com.ttopacademy.remotedatasources.interfaces.CategorySubjectRemoteDataSource
import retrofit2.Call
import javax.inject.Inject

/** CategorySubjectRemoteDataSource Implementation class.  */
class CategorySubjectRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
    ) : CategorySubjectRemoteDataSource {

    override fun getAllCategorySubjects(): Result<MutableList<CategorySubjectResponse>> {
        val apiCall: Call<MutableList<CategorySubjectResponse>> = apiService.allCategorySubjects
        return try {
            val categorySubjectResponses = apiCall.execute().body()!!
            Result.success(categorySubjectResponses)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return Result.failure(exception)
        }
    }
}