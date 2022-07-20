package com.ttopacademy.localdatasources.roomdb

import com.ttopacademy.localdatasources.entities.practicequestions.OtherPracticeQuestion
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.localdatasources.interfaces.SpecificPracticeQuestionLocalDataSource
import com.ttopacademy.localdatasources.roomdb.dao.OtherPracticeQuestionDao
import com.ttopacademy.utilities.DateTimeUtility
import java.util.*
import javax.inject.Inject

/** OtherPracticeQuestionLocalDataSource implementation class.  */
class OtherPracticeQuestionLocalDataSourceImpl @Inject constructor(
    private val otherPracticeQuestionDao: OtherPracticeQuestionDao,
    private  val dateTimeUtility: DateTimeUtility
) : SpecificPracticeQuestionLocalDataSource {

    override fun hasOutdatedPracticeQuestions(videoID: Int): Boolean {
        val todaysDate = Date()
        val lastUpdated = otherPracticeQuestionDao.getDateOfLastUpdate(videoID) ?: return true
        val dayDifference: Long = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated)
        return dayDifference > 1
    }

    override fun getPracticeQuestions(videoID: Int): MutableList<PracticeQuestion> {
        return otherPracticeQuestionDao.getPracticeQuestions(videoID)
    }

    override fun savePracticeQuestions(practiceQuestions: MutableList<PracticeQuestion>): Boolean {
        val otherPracticeQuestions: MutableList<OtherPracticeQuestion> = ArrayList()
        for (practiceQuestion in practiceQuestions) {
            otherPracticeQuestions.add(
                OtherPracticeQuestion(
                    practiceQuestion.practiceQuestionID, practiceQuestion.videoID,
                    practiceQuestion.questionNumber, practiceQuestion.question,
                    practiceQuestion.optionA, practiceQuestion.optionB,
                    practiceQuestion.optionC, practiceQuestion.optionD,
                    practiceQuestion.correctOption,
                    practiceQuestion.dateSavedToLocalDatabase
                )
            )
        }
        otherPracticeQuestionDao.insertPracticeQuestions(otherPracticeQuestions)
        return true
    }
}
