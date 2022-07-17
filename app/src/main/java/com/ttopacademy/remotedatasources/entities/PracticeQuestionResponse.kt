package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey
import com.ttopacademy.localdatasources.entities.practicequestions.Option

/** PracticeQuestionResponse entity class. */
data class PracticeQuestionResponse(

    /** Returns practiceQuestionID. */
    @PrimaryKey val practiceQuestionID: Int,

    /** Returns videoID. */
    val videoID: Int,

    /** Returns questionNumber. */
    val questionNumber: Int,

    /** Returns question. */
    val question: String,

    /** Returns optionA. */
    val optionA: String,

    /** Returns optionB. */
    val optionB: String,

    /** Returns optionC. */
    val optionC: String,

    /** Returns optionD. */
    val optionD: String,

    /** Returns correctOption. */
    val correctOption: Option
)
