package com.ttopacademy.tests.localdatasources

import com.ttopacademy.localdatasources.entities.practicequestions.Option
import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSource
import com.ttopacademy.localdatasources.interfaces.PracticeQuestionLocalDataSourceFactory
import com.ttopacademy.localdatasources.roomdb.PracticeQuestionLocalDataSourceFactoryImpl
import com.ttopacademy.localdatasources.roomdb.PracticeQuestionLocalDataSourceImpl
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeChemistryPracticeQuestionDao
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeMathPracticeQuestionDao
import com.ttopacademy.localdatasources.roomdb.fakedao.FakeOtherPracticeQuestionDao
import com.ttopacademy.localdatasources.roomdb.fakedao.FakePhysicsPracticeQuestionDao
import com.ttopacademy.utilities.FakeDateTimeUtility
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class PracticeQuestionLocalDataSourceTest {

    private lateinit var practiceQuestionLocalDataSource: PracticeQuestionLocalDataSource

    @Before
    fun initializeBeforeEachTest() {
        val practiceQuestionLocalDataSourceFactory: PracticeQuestionLocalDataSourceFactory =
            PracticeQuestionLocalDataSourceFactoryImpl(
                FakeMathPracticeQuestionDao(), FakePhysicsPracticeQuestionDao(),
                FakeChemistryPracticeQuestionDao(), FakeOtherPracticeQuestionDao(),
                FakeDateTimeUtility()
            )
        practiceQuestionLocalDataSource = PracticeQuestionLocalDataSourceImpl(
            practiceQuestionLocalDataSourceFactory
        )

        // PreSave
        val subjectName = "Geography"
        practiceQuestionLocalDataSource.savePracticeQuestions(subjectName, getMockPracticeQuestions())
    }

    @Test
    fun hasOutdatedPracticeQuestions_ShouldReturnTrueForGivenParameters() {
        val subjectName = "Geography"
        val videoID = 1
        val result =
            practiceQuestionLocalDataSource.hasOutdatedPracticeQuestions(subjectName, videoID)
        Assert.assertTrue(result)
    }

    @Test
    fun getPracticeQuestions_ShouldReturnAllForGivenParameters() {
        val subjectName = "Geography"
        val videoID = 1
        val result: List<PracticeQuestion> =
            practiceQuestionLocalDataSource.getPracticeQuestions(subjectName, videoID)
        Assert.assertEquals(2, result.size.toLong())
    }

    @Test
    fun savePracticeQuestions__ShouldReturnTrueAfterSaving() {
        val subjectName = "Geography"
        val practiceQuestions: MutableList<PracticeQuestion> = mutableListOf()
        practiceQuestions.add(
            PracticeQuestion(
                1, 1, 1, "Capital of Turkey?",
                "Kabul", "Texas", "Ohio", "New York", Option.A, Date()
            )
        )
        val result =
            practiceQuestionLocalDataSource.savePracticeQuestions(subjectName, practiceQuestions)
        Assert.assertTrue(result)
    }

    private fun getMockPracticeQuestions(): MutableList<PracticeQuestion> {
        val practiceQuestions: MutableList<PracticeQuestion> = mutableListOf()
        practiceQuestions.add(
            PracticeQuestion(1, 1, 1, "Capital of USA?",
                "Washington DC", "Texas", "Ohio", "New York", Option.A, Date()
            )
        )
        practiceQuestions.add(
            PracticeQuestion(
                2, 1, 2, "Capital of Nigeria?",
                "Lagos", "Abuja", "Kano", "Kaduna", Option.B, Date()
            )
        )
        return practiceQuestions
    }
}