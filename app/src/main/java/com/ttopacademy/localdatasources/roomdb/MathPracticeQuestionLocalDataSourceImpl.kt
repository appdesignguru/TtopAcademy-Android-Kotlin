package com.ttopacademy.localdatasources.roomdb

import com.ttopacademy.localdatasources.entities.practicequestions.MathPracticeQuestion
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.localdatasources.interfaces.SpecificPracticeQuestionLocalDataSource
import com.ttopacademy.localdatasources.roomdb.dao.MathPracticeQuestionDao
import com.ttopacademy.utilities.DateTimeUtility
import java.util.*
import javax.inject.Inject

/** MathPracticeQuestionLocalDataSource implementation class.  */
class MathPracticeQuestionLocalDataSourceImpl @Inject constructor(
    private val mathPracticeQuestionDao: MathPracticeQuestionDao,
    private val dateTimeUtility: DateTimeUtility
) : SpecificPracticeQuestionLocalDataSource {

    override fun hasOutdatedPracticeQuestions(videoID: Int): Boolean {
        val todaysDate = Date()
        val lastUpdated = mathPracticeQuestionDao.getDateOfLastUpdate(videoID) ?: return true
        val dayDifference: Long = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated)
        return dayDifference > 1
    }

    override fun getPracticeQuestions(videoID: Int): MutableList<PracticeQuestion> {
        return mathPracticeQuestionDao.getPracticeQuestions(videoID)
    }

    override fun savePracticeQuestions(practiceQuestions: MutableList<PracticeQuestion>): Boolean {
        val mathPracticeQuestions: MutableList<MathPracticeQuestion> = ArrayList()
        for (practiceQuestion in practiceQuestions) {
            mathPracticeQuestions.add(
                MathPracticeQuestion(
                    practiceQuestion.practiceQuestionID, practiceQuestion.videoID,
                    practiceQuestion.questionNumber, practiceQuestion.question,
                    practiceQuestion.optionA, practiceQuestion.optionB,
                    practiceQuestion.optionC, practiceQuestion.optionD,
                    practiceQuestion.correctOption,
                    practiceQuestion.dateSavedToLocalDatabase
                )
            )
        }
        mathPracticeQuestionDao.insertPracticeQuestions(mathPracticeQuestions)
        return true
    }
}
