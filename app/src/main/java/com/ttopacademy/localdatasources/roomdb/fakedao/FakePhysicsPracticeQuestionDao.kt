package com.ttopacademy.localdatasources.roomdb.fakedao

import com.ttopacademy.localdatasources.entities.practicequestions.PhysicsPracticeQuestion
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.localdatasources.roomdb.dao.PhysicsPracticeQuestionDao
import java.util.*
import javax.inject.Inject

/** Fake PhysicsPracticeQuestionDao dao implementation class. Used for unit testing only.  */
class FakePhysicsPracticeQuestionDao @Inject constructor()  : PhysicsPracticeQuestionDao {

    private val physicsPracticeQuestions: MutableList<PhysicsPracticeQuestion> = mutableListOf()

    override fun getPracticeQuestions(videoID: Int): MutableList<PracticeQuestion> {
        val result: MutableList<PracticeQuestion> = mutableListOf()
        for (practiceQuestion in physicsPracticeQuestions) {
            if (practiceQuestion.videoID == videoID) {
                result.add(practiceQuestion)
            }
        }
        return result
    }

    override fun insertPracticeQuestions(physicsPracticeQuestions: MutableList<PhysicsPracticeQuestion>) {
        this.physicsPracticeQuestions.clear()
        this.physicsPracticeQuestions.addAll(physicsPracticeQuestions)
    }

    override fun getDateOfLastUpdate(videoID: Int): Date? {
        return null
    }
}

