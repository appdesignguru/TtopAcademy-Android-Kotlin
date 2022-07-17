package com.ttopacademy.localdatasources.entities.practicequestions

import androidx.room.PrimaryKey
import java.util.*

open class PracticeQuestion(

    /** Returns practiceQuestionID. */
    @PrimaryKey open val practiceQuestionID: Int,

    /** Returns videoID. */
    open val videoID: Int,

    /** Returns questionNumber. */
    open val questionNumber: Int,

    /** Returns question. */
    open val question: String,

    /** Returns optionA. */
    open val optionA: String,

    /** Returns optionB. */
    open val optionB: String,

    /** Returns optionC. */
    open val optionC: String,

    /** Returns optionD. */
    open val optionD: String,

    /** Returns correctOption. */
    open val correctOption: Option,

    /** Returns dateSavedToLocalDatabase. */
    open val dateSavedToLocalDatabase: Date
)
