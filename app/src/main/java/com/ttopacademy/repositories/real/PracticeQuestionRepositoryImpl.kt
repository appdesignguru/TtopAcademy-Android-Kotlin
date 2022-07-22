package com.ttopacademy.repositories.real

import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSource
import com.ttopacademy.remotedatasources.entities.PracticeQuestionResponse
import com.ttopacademy.remotedatasources.interfaces.PracticeQuestionRemoteDataSource
import com.ttopacademy.repositories.interfaces.PracticeQuestionRepository
import java.util.*
import javax.inject.Inject

/** PracticeQuestionRepository implementation class. */
class PracticeQuestionRepositoryImpl @Inject constructor(
    private val practiceQuestionLocalDataSource: PracticeQuestionLocalDataSource,
    private val practiceQuestionRemoteDataSource: PracticeQuestionRemoteDataSource
) : PracticeQuestionRepository {

    override fun getPracticeQuestions(subjectName: String, videoID: Int): MutableList<PracticeQuestion> {
        if (practiceQuestionLocalDataSource.hasOutdatedPracticeQuestions(subjectName, videoID)) {
            refreshPracticeQuestions(subjectName, videoID)
        }
        return practiceQuestionLocalDataSource.getPracticeQuestions(subjectName, videoID)
    }

    private fun refreshPracticeQuestions(subjectName: String, videoID: Int) {
        val result: Result<MutableList<PracticeQuestionResponse>> =
            practiceQuestionRemoteDataSource.getPracticeQuestions(subjectName, videoID)
        if (result.isSuccess) {
            val practiceQuestionResponses: MutableList<PracticeQuestionResponse>? = result.getOrNull()
            if (practiceQuestionResponses != null){
                updatePracticeQuestionLocalDataSource(subjectName, practiceQuestionResponses)
            }
        }
    }

    private fun updatePracticeQuestionLocalDataSource(
        subjectName: String, practiceQuestionResponses: MutableList<PracticeQuestionResponse>
    ) {
        val practiceQuestions: MutableList<PracticeQuestion> = mutableListOf()
        val dateSavedToLocalDatabase = Date()
        for ((practiceQuestionID, videoID, questionNumber, question, optionA, optionB,
            optionC, optionD, correctOption) in practiceQuestionResponses) {
            practiceQuestions.add(
                PracticeQuestion(practiceQuestionID, videoID, questionNumber, question,
                    optionA, optionB, optionC, optionD, correctOption, dateSavedToLocalDatabase
                )
            )
        }
        practiceQuestionLocalDataSource.savePracticeQuestions(subjectName, practiceQuestions)
    }
}