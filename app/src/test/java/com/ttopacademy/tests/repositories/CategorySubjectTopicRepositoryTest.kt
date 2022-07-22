package com.ttopacademy.tests.repositories

import com.ttopacademy.localdatasources.entities.CategorySubjectTopic
import com.ttopacademy.localdatasources.fakes.FakeCategorySubjectTopicLocalDataSource
import com.ttopacademy.remotedatasources.fakes.FakeCategorySubjectTopicRemoteDataSource
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicRepository
import com.ttopacademy.repositories.real.CategorySubjectTopicRepositoryImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CategorySubjectTopicRepositoryTest {

    private lateinit var categorySubjectTopicRepository: CategorySubjectTopicRepository

    @Before
    fun initializeBeforeEachTest() {
        categorySubjectTopicRepository = CategorySubjectTopicRepositoryImpl(
            FakeCategorySubjectTopicLocalDataSource(), FakeCategorySubjectTopicRemoteDataSource()
        )
    }

    @Test
    fun getCategorySubjectTopicID_ShouldReturnValueForGivenParameters() {
        val categorySubjectID = 1
        val topicID = 1
        val result =
            categorySubjectTopicRepository.getCategorySubjectTopicID(categorySubjectID, topicID)
        Assert.assertEquals(1, result)
    }

    @Test
    fun getCategorySubjectTopics_ShouldReturnForGivenParameter() {
        val categorySubjectID = 4
        val result: List<CategorySubjectTopic> =
            categorySubjectTopicRepository.getCategorySubjectTopics(categorySubjectID)
        Assert.assertEquals(1, result.size)
    }
}