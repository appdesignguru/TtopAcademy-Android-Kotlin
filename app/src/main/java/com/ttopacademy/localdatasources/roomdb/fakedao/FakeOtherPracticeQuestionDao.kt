package com.ttopacademy.localdatasources.roomdb.fakedao

import com.ttopacademy.localdatasources.entities.practicequestions.OtherPracticeQuestion
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.localdatasources.roomdb.dao.OtherPracticeQuestionDao
import java.util.*
import javax.inject.Inject

/** Fake OtherPracticeQuestionDao dao implementation class. Used for unit testing only.  */
class FakeOtherPracticeQuestionDao  @Inject constructor() : OtherPracticeQuestionDao {

    private val otherPracticeQuestions: MutableList<OtherPracticeQuestion> = mutableListOf()

    override fun getPracticeQuestions(videoID: Int): MutableList<PracticeQuestion> {
        val result: MutableList<PracticeQuestion> = mutableListOf()
        for (practiceQuestion in otherPracticeQuestions) {
            if (practiceQuestion.videoID == videoID) {
                result.add(practiceQuestion)
            }
        }
        return result
    }

    override fun insertPracticeQuestions(otherPracticeQuestions: MutableList<OtherPracticeQuestion>) {
        this.otherPracticeQuestions.clear()
        this.otherPracticeQuestions.addAll(otherPracticeQuestions)
    }

    override fun getDateOfLastUpdate(videoID: Int): Date? {
        return null
    }
}

