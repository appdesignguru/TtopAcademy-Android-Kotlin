package com.ttopacademy.remotedatasources.fakes

import com.ttopacademy.localdatasources.entities.practicequestions.Option
import com.ttopacademy.remotedatasources.entities.PracticeQuestionResponse
import com.ttopacademy.remotedatasources.interfaces.PracticeQuestionRemoteDataSource
import javax.inject.Inject

/** Fake PracticeQuestion remote data source implementation class. Used for unit testing only. */
class FakePracticeQuestionRemoteDataSource @Inject constructor()
    : PracticeQuestionRemoteDataSource {

    override fun getPracticeQuestions(
        subjectName: String,
        videoID: Int
    ): Result<MutableList<PracticeQuestionResponse>> {
        val mockPracticeQuestionResponses: MutableList<PracticeQuestionResponse> = mutableListOf()
        mockPracticeQuestionResponses.add(
            PracticeQuestionResponse(
                1, 1, 1,
                "What is name of the president of USA?", "Donald Trump",
                "Barrack Obama", "Joe Biden", "Jack Gudh", Option.C
            )
        )
        mockPracticeQuestionResponses.add(
            PracticeQuestionResponse(
                2, 1, 1,
                "What is name of the president of Nigeria?", "Buhari",
                "Jonathan", "Obasanjo", "Yaradua", Option.C
            )
        )

        return Result.success(mockPracticeQuestionResponses)
    }
}