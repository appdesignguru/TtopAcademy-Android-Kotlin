package com.ttopacademy.remotedatasources.retrofit

import com.ttopacademy.remotedatasources.entities.PracticeQuestionResponse
import com.ttopacademy.remotedatasources.interfaces.PracticeQuestionRemoteDataSource
import retrofit2.Call
import javax.inject.Inject

/** PracticeQuestionRemoteDataSource Implementation class.  */
class PracticeQuestionRemoteDataSourceImpl
/** Constructs a new instance.  */ @Inject constructor(private val apiService: ApiService) :
    PracticeQuestionRemoteDataSource {
    override fun getPracticeQuestions(
        subjectName: String,
        videoID: Int
    ): Result<MutableList<PracticeQuestionResponse>> {
        val hyphenConcatenatedSubjectNameAndVideoID = "$subjectName-$videoID"
        val apiCall: Call<MutableList<PracticeQuestionResponse>> =
            apiService.getPracticeQuestions(hyphenConcatenatedSubjectNameAndVideoID)
        return try {
            val practiceQuestionResponses = apiCall.execute().body()!!
            Result.success(practiceQuestionResponses)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return Result.failure(exception)
        }
    }
}