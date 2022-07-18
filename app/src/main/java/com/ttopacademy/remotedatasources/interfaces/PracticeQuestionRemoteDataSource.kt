package com.ttopacademy.remotedatasources.interfaces

import com.ttopacademy.remotedatasources.entities.PracticeQuestionResponse

/** Practice question remote data source interface.  */
interface PracticeQuestionRemoteDataSource {

    /** Returns practice questions for given parameters.  */
    fun getPracticeQuestions(
        subjectName: String,
        videoID: Int
    ): Result<MutableList<PracticeQuestionResponse>>
}
