package com.ttopacademy.localdatasources.interfaces

import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion

/** PracticeQuestion local data source interface for specific subject. */
interface SpecificPracticeQuestionLocalDataSource {

    /** Checks whether the practice questions for given parameter is NOT up-to-date.  */
    fun hasOutdatedPracticeQuestions(videoID: Int): Boolean

    /** Returns practice questions for given parameter.  */
    fun getPracticeQuestions(videoID: Int): MutableList<PracticeQuestion>

    /** Returns true after saving successfully.  */
    fun savePracticeQuestions(practiceQuestions: MutableList<PracticeQuestion>): Boolean

}