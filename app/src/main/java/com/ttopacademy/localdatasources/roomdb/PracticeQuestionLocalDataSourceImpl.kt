package com.ttopacademy.localdatasources.roomdb

import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSource
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSourceFactory
import com.ttopacademy.localdatasources.interfaces.SpecificPracticeQuestionLocalDataSource
import javax.inject.Inject

/** PracticeQuestion local data source implementation class.  */
class PracticeQuestionLocalDataSourceImpl  @Inject constructor(
    private val practiceQuestionLocalDataSourceFactory: PracticeQuestionLocalDataSourceFactory
) : PracticeQuestionLocalDataSource {

    override fun hasOutdatedPracticeQuestions(subjectName: String, videoID: Int): Boolean {
        return getSpecificPracticeQuestionLocalDataSource(subjectName).hasOutdatedPracticeQuestions(
            videoID
        )
    }

    override fun getPracticeQuestions(subjectName: String, videoID: Int): MutableList<PracticeQuestion> {
        return getSpecificPracticeQuestionLocalDataSource(subjectName).getPracticeQuestions(videoID)
    }

    override fun savePracticeQuestions(subjectName: String, practiceQuestions: MutableList<PracticeQuestion>)
    : Boolean {
        return getSpecificPracticeQuestionLocalDataSource(subjectName).savePracticeQuestions(
            practiceQuestions
        )
    }

    private fun getSpecificPracticeQuestionLocalDataSource(subjectName: String): SpecificPracticeQuestionLocalDataSource {
        return practiceQuestionLocalDataSourceFactory.getSpecificPracticeQuestionLocalDataSource(
            subjectName
        )
    }
}
