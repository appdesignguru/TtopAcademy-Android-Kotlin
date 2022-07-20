package com.ttopacademy.localdatasources.roomdb.fakedao

import com.ttopacademy.localdatasources.entities.practicequestions.ChemistryPracticeQuestion
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.localdatasources.roomdb.dao.ChemistryPracticeQuestionDao
import java.util.*
import javax.inject.Inject

/** Fake ChemistryPracticeQuestionDao dao implementation class. Used for unit testing only.  */
class FakeChemistryPracticeQuestionDao @Inject constructor() : ChemistryPracticeQuestionDao {

    private val chemistryPracticeQuestions: MutableList<ChemistryPracticeQuestion> = mutableListOf()

    override fun getPracticeQuestions(videoID: Int): MutableList<PracticeQuestion> {
        val result: MutableList<PracticeQuestion> = mutableListOf()
        for (practiceQuestion in chemistryPracticeQuestions) {
            if (practiceQuestion.videoID == videoID) {
                result.add(practiceQuestion)
            }
        }
        return result
    }

    override fun insertPracticeQuestions(chemistryPracticeQuestions: MutableList<ChemistryPracticeQuestion>) {
        this.chemistryPracticeQuestions.clear()
        this.chemistryPracticeQuestions.addAll(chemistryPracticeQuestions)
    }

    override fun getDateOfLastUpdate(videoID: Int): Date? {
        return null
    }
}