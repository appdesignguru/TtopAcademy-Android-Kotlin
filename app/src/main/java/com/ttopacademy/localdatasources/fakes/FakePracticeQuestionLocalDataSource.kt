package com.ttopacademy.localdatasources.fakes

import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSource
import javax.inject.Inject

/** Fake PracticeQuestion local data source implementation class. Used for unit testing only. */
class FakePracticeQuestionLocalDataSource @Inject constructor() : PracticeQuestionLocalDataSource {

    private val practiceQuestions: MutableList<PracticeQuestion> = mutableListOf()

    override fun hasOutdatedPracticeQuestions(subjectName: String, videoID: Int): Boolean {
        return true
    }

    override fun getPracticeQuestions(
        subjectName: String,
        videoID: Int
    ): MutableList<PracticeQuestion> {
        val result: MutableList<PracticeQuestion> = mutableListOf()
        for (practiceQuestion in practiceQuestions) {
            if (practiceQuestion.videoID == videoID) {
                result.add(practiceQuestion)
            }
        }
        return result
    }

    override fun savePracticeQuestions(
        subjectName: String,
        practiceQuestions: MutableList<PracticeQuestion>
    ): Boolean {
        this.practiceQuestions.clear()
        this.practiceQuestions.addAll(practiceQuestions)
        return true
    }
}