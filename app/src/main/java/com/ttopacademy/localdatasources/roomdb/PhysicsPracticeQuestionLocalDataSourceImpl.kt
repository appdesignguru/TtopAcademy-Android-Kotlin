package com.ttopacademy.localdatasources.roomdb

import com.ttopacademy.localdatasources.entities.practicequestions.PhysicsPracticeQuestion
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.localdatasources.interfaces.SpecificPracticeQuestionLocalDataSource
import com.ttopacademy.localdatasources.roomdb.dao.PhysicsPracticeQuestionDao
import com.ttopacademy.utilities.DateTimeUtility
import java.util.*
import javax.inject.Inject

/** PhysicsPracticeQuestionLocalDataSource implementation class.  */
class PhysicsPracticeQuestionLocalDataSourceImpl @Inject constructor(
    private val physicsPracticeQuestionDao: PhysicsPracticeQuestionDao,
    private val dateTimeUtility: DateTimeUtility
) : SpecificPracticeQuestionLocalDataSource {

    override fun hasOutdatedPracticeQuestions(videoID: Int): Boolean {
        val todaysDate = Date()
        val lastUpdated = physicsPracticeQuestionDao.getDateOfLastUpdate(videoID) ?: return true
        val dayDifference: Long = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated)
        return dayDifference > 1
    }

    override fun getPracticeQuestions(videoID: Int): MutableList<PracticeQuestion> {
        return physicsPracticeQuestionDao.getPracticeQuestions(videoID)
    }

    override fun savePracticeQuestions(practiceQuestions: MutableList<PracticeQuestion>): Boolean {
        val physicsPracticeQuestions: MutableList<PhysicsPracticeQuestion> = ArrayList()
        for (practiceQuestion in practiceQuestions) {
            physicsPracticeQuestions.add(
                PhysicsPracticeQuestion(
                    practiceQuestion.practiceQuestionID, practiceQuestion.videoID,
                    practiceQuestion.questionNumber, practiceQuestion.question,
                    practiceQuestion.optionA, practiceQuestion.optionB,
                    practiceQuestion.optionC, practiceQuestion.optionD,
                    practiceQuestion.correctOption,
                    practiceQuestion.dateSavedToLocalDatabase
                )
            )
        }
        physicsPracticeQuestionDao.insertPracticeQuestions(physicsPracticeQuestions)
        return true
    }
}
