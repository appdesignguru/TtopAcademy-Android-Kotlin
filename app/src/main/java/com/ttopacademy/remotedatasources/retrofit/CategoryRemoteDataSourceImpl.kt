package com.ttopacademy.remotedatasources.retrofit

import com.ttopacademy.remotedatasources.entities.CategoryResponse
import com.ttopacademy.remotedatasources.interfaces.CategoryRemoteDataSource
import javax.inject.Inject

/** CategoryRemoteDataSource Implementation class.  */
class CategoryRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
    ) : CategoryRemoteDataSource {

    override fun getAllCategories(): Result<MutableList<CategoryResponse>> {
        val apiCall = apiService.allCategories
        return try {
            val categoryResponses = apiCall.execute().body()!!
            Result.success(categoryResponses)
        } catch (exception: Exception){
            exception.printStackTrace()
            return Result.failure(exception)
        }
    }
}
