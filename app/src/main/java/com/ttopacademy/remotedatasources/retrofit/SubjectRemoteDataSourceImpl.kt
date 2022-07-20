package com.ttopacademy.remotedatasources.retrofit

import com.ttopacademy.remotedatasources.entities.SubjectResponse
import com.ttopacademy.remotedatasources.interfaces.SubjectRemoteDataSource
import retrofit2.Call
import javax.inject.Inject

/** SubjectRemoteDataSource Implementation class.  */
class SubjectRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
    ) : SubjectRemoteDataSource {

    override fun getAllSubjects(): Result<MutableList<SubjectResponse>> {
        val apiCall: Call<MutableList<SubjectResponse>> = apiService.allSubjects
        return try {
            val subjectResponses = apiCall.execute().body()!!
            Result.success(subjectResponses)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return Result.failure(exception)
        }
    }
}