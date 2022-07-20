package com.ttopacademy.localdatasources.entities.practicequestions

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/** MathPracticeQuestion entity class. */
@Entity
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
    override var dateSavedToLocalDatabase: Date?
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