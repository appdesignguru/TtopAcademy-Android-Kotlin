package com.ttopacademy.remotedatasources.entities

import androidx.room.PrimaryKey
import com.ttopacademy.localdatasources.entities.practicequestions.Option

/** PracticeQuestionResponse entity class. */
data class PracticeQuestionResponse(
    @PrimaryKey val practiceQuestionID: Int,
    val videoID: Int,
    val questionNumber: Int,
    val question: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val correctOption: Option
)
