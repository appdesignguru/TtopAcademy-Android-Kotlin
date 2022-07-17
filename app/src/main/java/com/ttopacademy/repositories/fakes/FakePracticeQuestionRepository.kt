package com.ttopacademy.repositories.fakes

import com.ttopacademy.localdatasources.entities.practicequestions.Option
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.repositories.interfaces.PracticeQuestionRepository
import java.util.*
import javax.inject.Inject

/** Fake PracticeQuestion repository implementation class. Used for unit testing only. */
class FakePracticeQuestionRepository @Inject constructor() : PracticeQuestionRepository {

    override fun getPracticeQuestions(subjectName: String, videoID: Int): MutableList<PracticeQuestion> {
        val mockPracticeQuestions: MutableList<PracticeQuestion> = mutableListOf()
        mockPracticeQuestions.add(
            PracticeQuestion(
                1, 1, 1,
                "What is name of the president of USA?", "Donald Trump",
                "Barrack Obama", "Joe Biden", "Jack Gudh", Option.C, Date()
            )
        )
        mockPracticeQuestions.add(
            PracticeQuestion(
                2, 1, 1,
                "What is name of the president of Nigeria?", "Buhari",
                "Jonathan", "Obasanjo", "Yaradua", Option.C, Date()
            )
        )

        return mockPracticeQuestions
    }
}