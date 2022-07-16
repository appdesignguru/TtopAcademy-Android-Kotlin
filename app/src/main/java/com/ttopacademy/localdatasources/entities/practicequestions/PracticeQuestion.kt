package com.ttopacademy.localdatasources.entities.practicequestions

import androidx.room.PrimaryKey
import java.util.*

open class PracticeQuestion(
    @PrimaryKey open val practiceQuestionID: Int,
    open val videoID: Int,
    open val questionNumber: Int,
    open val question: String,
    open val optionA: String,
    open val optionB: String,
    open val optionC: String,
    open val optionD: String,
    open val correctOption: Option,
    open val dateSavedToLocalDatabase: Date
)
