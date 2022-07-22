package com.ttopacademy.tests.repositories

import com.ttopacademy.localdatasources.entities.practicequestions.PracticeQuestion
import com.ttopacademy.localdatasources.fakes.FakePracticeQuestionLocalDataSource
import com.ttopacademy.remotedatasources.fakes.FakePracticeQuestionRemoteDataSource
import com.ttopacademy.repositories.interfaces.PracticeQuestionRepository
import com.ttopacademy.repositories.real.PracticeQuestionRepositoryImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PracticeQuestionRepositoryTest {

    private lateinit var practiceQuestionRepository: PracticeQuestionRepository

    @Before
    fun initializeBeforeEachTest() {
        practiceQuestionRepository = PracticeQuestionRepositoryImpl(
            FakePracticeQuestionLocalDataSource(), FakePracticeQuestionRemoteDataSource()
        )
    }

    @Test
    fun getPracticeQuestionsSync_ShouldReturnForGivenParameters() {
        val subjectName = "Biology"
        val videoID = 1
        val result: List<PracticeQuestion> =
            practiceQuestionRepository.getPracticeQuestions(subjectName, videoID)
        Assert.assertEquals(2, result.size)
    }
}