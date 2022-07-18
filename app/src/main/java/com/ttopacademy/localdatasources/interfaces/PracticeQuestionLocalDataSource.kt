package com.ttopacademy.localdatasources.interfaces

import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion

/** PracticeQuestion local data source interface. */
interface PracticeQuestionLocalDataSource {

    /** Checks whether the practice questions for given parameters is NOT up-to-date.  */
    fun hasOutdatedPracticeQuestions(subjectName: String, videoID: Int): Boolean

    /** Returns practice questions for given parameters.  */
    fun getPracticeQuestions(subjectName: String, videoID: Int): MutableList<PracticeQuestion>

    /** Returns true after saving successfully.  */
    fun savePracticeQuestions(
        subjectName: String,
        practiceQuestions: MutableList<PracticeQuestion>
    ): Boolean

}