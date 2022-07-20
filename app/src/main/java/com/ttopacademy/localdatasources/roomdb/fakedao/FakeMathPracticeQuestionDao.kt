package com.ttopacademy.localdatasources.roomdb.fakedao

import com.ttopacademy.localdatasources.entities.practicequestions.MathPracticeQuestion
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.localdatasources.roomdb.dao.MathPracticeQuestionDao
import java.util.*
import javax.inject.Inject

/** Fake MathPracticeQuestionDao dao implementation class. Used for unit testing only.  */
class FakeMathPracticeQuestionDao @Inject constructor() : MathPracticeQuestionDao {

    private val mathPracticeQuestions: MutableList<MathPracticeQuestion> = mutableListOf()

    override fun getPracticeQuestions(videoID: Int): MutableList<PracticeQuestion> {
        val result: MutableList<PracticeQuestion> = ArrayList()
        for (practiceQuestion in mathPracticeQuestions) {
            if (practiceQuestion.videoID == videoID) {
                result.add(practiceQuestion)
            }
        }
        return result
    }

    override fun insertPracticeQuestions(mathPracticeQuestions: MutableList<MathPracticeQuestion>) {
        this.mathPracticeQuestions.clear()
        this.mathPracticeQuestions.addAll(mathPracticeQuestions)
    }

    override fun getDateOfLastUpdate(videoID: Int): Date? {
        return null
    }
}

