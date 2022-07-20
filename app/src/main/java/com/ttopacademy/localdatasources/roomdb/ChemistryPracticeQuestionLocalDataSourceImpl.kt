package com.ttopacademy.localdatasources.roomdb

import com.ttopacademy.localdatasources.entities.practicequestions.ChemistryPracticeQuestion
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.localdatasources.interfaces.SpecificPracticeQuestionLocalDataSource
import com.ttopacademy.localdatasources.roomdb.dao.ChemistryPracticeQuestionDao
import com.ttopacademy.utilities.DateTimeUtility
import java.util.*
import javax.inject.Inject

/** ChemistryPracticeQuestionLocalDataSource implementation class.  */
class ChemistryPracticeQuestionLocalDataSourceImpl @Inject constructor(
    private val chemistryPracticeQuestionDao: ChemistryPracticeQuestionDao,
    private val dateTimeUtility: DateTimeUtility
) : SpecificPracticeQuestionLocalDataSource {

    override fun hasOutdatedPracticeQuestions(videoID: Int): Boolean {
        val todaysDate = Date()
        val lastUpdated = chemistryPracticeQuestionDao.getDateOfLastUpdate(videoID) ?: return true
        val dayDifference: Long = dateTimeUtility.numberOfDaysBetween(todaysDate, lastUpdated)
        return dayDifference > 1
    }

    override fun getPracticeQuestions(videoID: Int): MutableList<PracticeQuestion> {
        return chemistryPracticeQuestionDao.getPracticeQuestions(videoID)
    }

    override fun savePracticeQuestions(practiceQuestions: MutableList<PracticeQuestion>): Boolean {
        val chemistryPracticeQuestions: MutableList<ChemistryPracticeQuestion> = ArrayList()
        for (practiceQuestion in practiceQuestions) {
            chemistryPracticeQuestions.add(
                ChemistryPracticeQuestion(
                    practiceQuestion.practiceQuestionID, practiceQuestion.videoID,
                    practiceQuestion.questionNumber, practiceQuestion.question,
                    practiceQuestion.optionA, practiceQuestion.optionB,
                    practiceQuestion.optionC, practiceQuestion.optionD,
                    practiceQuestion.correctOption,
                    practiceQuestion.dateSavedToLocalDatabase
                )
            )
        }
        chemistryPracticeQuestionDao.insertPracticeQuestions(chemistryPracticeQuestions)
        return true
    }
}
