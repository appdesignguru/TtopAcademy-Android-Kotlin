package com.ttopacademy.localdatasources.entities.practicequestions

import androidx.room.PrimaryKey
import java.util.*

class MathPracticeQuestion (
    @PrimaryKey override val practiceQuestionID: Int,
    override val videoID: Int,
    override val questionNumber: Int,
    override val question: String,
    override val optionA: String,
    override val optionB: String,
    override val optionC: String,
    override val optionD: String,
    override val correctOption: Option,
    override val dateSavedToLocalDatabase: Date
) : PracticeQuestion(
    practiceQuestionID,
    videoID,
    questionNumber,
    question,
    optionA,
    optionB,
    optionC,
    optionD,
    correctOption,
    dateSavedToLocalDatabase
)