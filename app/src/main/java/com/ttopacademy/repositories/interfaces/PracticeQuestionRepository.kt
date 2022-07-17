package com.ttopacademy.repositories.interfaces

import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion

/** Repository interface for practice questions. */
interface PracticeQuestionRepository {

    /** Returns the practice questions for given parameters.  */
    fun getPracticeQuestions(subjectName: String, videoID: Int): MutableList<PracticeQuestion>

}