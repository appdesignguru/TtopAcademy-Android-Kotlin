package com.ttopacademy.tests.repositories

import com.ttopacademy.localdatasources.entities.CategorySubjectTopicVideo
import com.ttopacademy.localdatasources.fakes.FakeCategorySubjectTopicVideoLocalDataSource
import com.ttopacademy.remotedatasources.fakes.FakeCategorySubjectTopicVideoRemoteDataSource
import com.ttopacademy.repositories.interfaces.CategorySubjectTopicVideoRepository
import com.ttopacademy.repositories.real.CategorySubjectTopicVideoRepositoryImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CategorySubjectTopicVideoRepositoryTest {

    private lateinit var categorySubjectTopicVideoRepository: CategorySubjectTopicVideoRepository

    @Before
    fun initializeBeforeEachTest() {
        categorySubjectTopicVideoRepository = CategorySubjectTopicVideoRepositoryImpl(
            FakeCategorySubjectTopicVideoLocalDataSource(),
            FakeCategorySubjectTopicVideoRemoteDataSource()
        )
    }

    @Test
    fun getCategorySubjectTopicVideoID_ShouldReturnValueForGivenParameters() {
        val categorySubjectTopicID = 5
        val videoID = 1
        val result = categorySubjectTopicVideoRepository.getCategorySubjectTopicVideoID(
            categorySubjectTopicID,
            videoID
        )
        Assert.assertEquals(9, result)
    }

    @Test
    fun getCategorySubjectTopicVideos_ShouldReturnForGivenParameter() {
        val categorySubjectTopicID = 8
        val result: List<CategorySubjectTopicVideo> =
            categorySubjectTopicVideoRepository.getCategorySubjectTopicVideos(categorySubjectTopicID)
        Assert.assertEquals(2, result.size)
    }
}